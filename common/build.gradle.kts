plugins {
    kotlin("multiplatform") version "1.6.10"
}

group = "com.example"
version = "0.0.1"

kotlin {
    js(IR) {
        browser {
            binaries.executable()
        }
    }
    jvm()
}

tasks {
    "build" {
        doLast {
            copy {
                from("$buildDir/processedResources/js/main")
                into("$buildDir/libs/common-types")
            }
            copy {
                from("$buildDir/compileSync/main/productionExecutable/kotlin")
                into("$buildDir/libs/common-types")
                rename { name -> name.replace("${rootProject.name}-common", "index") }
            }
        }
        finalizedBy(":aliasFrontend:addCommonTypes", ":codenamesFrontend:addCommonTypes")
    }
}
