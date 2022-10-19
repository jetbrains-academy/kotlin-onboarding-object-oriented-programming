plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.6.10" apply false
    id("org.jetbrains.kotlin.multiplatform") version "1.6.10" apply false
    application
}

fun printOutput(output: Any): Task {
    return tasks.create("printOutput") {
        println("#educational_plugin_check(er_version 1")
        val lines = output.toString().split("(?<=\n)|(?=\n)")
        for (line in lines) {
            println("#educational_plugin$line")
        }
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

val commonNames = listOf("common", "aliasFrontend")
configure(subprojects.filter { it.name !in commonNames }) {
    tasks {
        withType<Test> {
            useJUnitPlatform()

            outputs.upToDateWhen { false }

            addTestListener(object : TestListener {
                override fun beforeSuite(suite: TestDescriptor) {}
                override fun beforeTest(testDescriptor: TestDescriptor) {}
                override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
                    if (result.resultType == TestResult.ResultType.FAILURE) {
                        val message = result.exception?.message ?: "Wrong answer"
                        val lines = message.split("\n")
                        println("#educational_plugin FAILED + ${lines[0]}")
                        lines.subList(1, lines.size).forEach { line ->
                            println("#educational_plugin$line")
                        }
                        // we need this to separate output of different tests
                        println()
                    }
                }

                override fun afterSuite(suite: TestDescriptor, result: TestResult) {}
            })
        }
    }
}