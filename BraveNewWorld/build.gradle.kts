import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "jetbrains.kotlin.course"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

dependencies {
    implementation(project(":common"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    implementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
    runtimeOnly("org.junit.platform:junit-platform-console:1.8.2")
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

tasks.withType<Test> {
    useJUnitPlatform()
}

var env = "production"

val setDev = tasks.register("setDev") {
    env = "development"
}

tasks.named("processResources") {
    dependsOn(":aliasFrontend:build")
}

sourceSets {
    getByName("main").java.srcDirs("alias/src/main/kotlin")
    getByName("test").java.srcDirs("alias/test")
}
