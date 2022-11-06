import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.6.10"
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    implementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
    runtimeOnly("org.junit.platform:junit-platform-console:1.8.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "9"
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "9"
    targetCompatibility = "9"
}
