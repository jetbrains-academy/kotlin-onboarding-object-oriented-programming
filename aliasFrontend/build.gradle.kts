plugins {
    id("org.siouan.frontend-jdk11") version "6.0.0"
}

frontend {
    nodeDistributionProvided.set(false)
    nodeVersion.set("16.17.1")

    yarnEnabled.set(true)
    yarnVersion.set("3.0.0")

    installScript.set("install")
    assembleScript.set("build")
}

val addCommonTypes = tasks.register<Exec>("addCommonTypes") {
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
                into("$rootDir/BraveNewWorld/alias/src/main/resources/static/")
            }
        }
    }
}
