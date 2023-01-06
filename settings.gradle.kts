rootProject.name = "CSC_Kotlin_Course_Part2"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

include(
    "common",
    "utils",

    "aliasFrontend",
    "aliasServer",

    "codenamesServer",
    "codenamesFrontend",

    "wordsGeneratorFrontend",
    "wordsGeneratorServer",
)