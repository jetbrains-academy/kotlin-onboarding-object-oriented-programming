group = rootProject.group
version = rootProject.version

plugins {
    java
    id(libs.plugins.kotlin.jvm.get().pluginId)
}

dependencies {
    implementation(libs.kotlin.reflect)
}
