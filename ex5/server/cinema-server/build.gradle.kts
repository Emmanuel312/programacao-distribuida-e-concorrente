plugins {
    kotlin("jvm") version "1.5.10"
    application
    kotlin("plugin.serialization") version "1.5.31"
}

group = "br.com.cinema"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
}

application {
    mainClass.set("br.com.cinema.server.ApplicationKt")
}