import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "jetbrains.kotlin.course"
version = "0.0.1-SNAPSHOT"

fun properties(key: String) = project.findProperty(key).toString()

@Suppress("DSL_SCOPE_VIOLATION") // "libs" produces a false-positive warning, see https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    java
    val kotlinVersion = libs.versions.kotlin.get()
    id(libs.plugins.kotlin.jvm.get().pluginId) version kotlinVersion apply false
    id(libs.plugins.kotlin.multiplatform.get().pluginId) version kotlinVersion apply false
    id("org.springframework.boot") version libs.versions.springframework.get() apply false
    id("io.spring.dependency-management") version libs.versions.spring.dependency.management.get() apply false
    id("org.jetbrains.kotlin.plugin.spring") version libs.versions.spring.plugin.get() apply false

    id("org.siouan.frontend-jdk11") version libs.versions.frontend.jdk11.get()
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

// TODO:
// вынести в отдельные модули общий код
// добавить конфигурации
// добавить промежутчоные шаги с запуском проекта

tasks {
    wrapper {
        gradleVersion = properties("gradleVersion")
    }
}

val alias = "alias"
val codenames = "codenames"
val wordsGenerator = "wordsGenerator"
val frontend = "Frontend"
val server = "Server"

val ignored = listOf("common", "$alias$frontend", "$codenames$frontend", "$wordsGenerator$frontend")
configure(subprojects.filter { it.name !in ignored }) {
    val jvmVersion = "11"

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = jvmVersion
            }
        }

        withType<JavaCompile> {
            sourceCompatibility = jvmVersion
            targetCompatibility = jvmVersion
        }

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

val servers = mapOf(
    "$alias$server" to alias,
    "$codenames$server" to codenames,
    "$wordsGenerator$server" to wordsGenerator
)
configure(subprojects.filter { it.name in servers.keys }) {
    val projectName = this.name

    apply {
        plugin("java")
        plugin("kotlin")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
    }

    dependencies {
        implementation(project(":common"))
        implementation(project(":utils"))

        implementation(rootProject.libs.spring.boot.starter.web)
        implementation(rootProject.libs.kotlin.reflect)
        implementation(rootProject.libs.jackson.module.kotlin)

        testImplementation(rootProject.libs.junit.jupiter.api)
        testRuntimeOnly(rootProject.libs.junit.jupiter.engine)
        testImplementation(rootProject.libs.junit.jupiter.params)
        testRuntimeOnly(rootProject.libs.junit.platform.console)
    }

    tasks.named("processResources") {
        dependsOn(":${servers[projectName]!!}Frontend:build")
    }

    sourceSets {
        getByName("main").java.srcDirs("${servers[projectName]!!}/src/main/kotlin")
        getByName("main").resources.srcDirs("${servers[projectName]!!}/src/main/resources")
        getByName("test").java.srcDirs("${servers[projectName]!!}/test")
    }
}

val clients = mapOf(
    "$alias$frontend" to alias,
    "$codenames$frontend" to codenames,
    "$wordsGenerator$frontend" to wordsGenerator
)
configure(subprojects.filter { it.name in clients.keys }) {
    val projectName = this.name

    apply {
        plugin("org.siouan.frontend-jdk11")
    }

    frontend {
        nodeDistributionProvided.set(false)
        nodeVersion.set(rootProject.libs.versions.node.get())

        yarnEnabled.set(true)
        yarnVersion.set(rootProject.libs.versions.yarn.get())

        installScript.set("install")
        // TODO: throws a stack overflow error
//        assembleScript.set("build")
    }

    tasks.register<Exec>("addCommonTypes") {
        outputs.upToDateWhen { false }
        workingDir = projectDir
        commandLine("yarn", "remove", "common-types")
        commandLine("yarn", "add", "common-types@file:$rootDir/common/build/libs/common-types")
    }

    tasks {
        "build" {
            dependsOn(":common:build")
            doLast {
                copy {
                    from("$buildDir")
                    into("$rootDir/${clients[projectName]!!}$server/${clients[projectName]!!}/src/main/resources/static/")
                }
            }
        }
    }
}