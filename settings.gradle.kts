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
    "aliasFrontend",
    "aliasServer",
    "utils",
    "codenamesServer",
    "codenamesFrontend",
)