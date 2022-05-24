import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    application
    id("io.gitlab.arturbosch.detekt") version "1.19.0"
}

group = "com.stringconcat"
version = "1.0-SNAPSHOT"

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}