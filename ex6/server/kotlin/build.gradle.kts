import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*

group = "br.com.cinema.server"
version = "0.0.1-SNAPSHOT"

val protobufVersion = "3.19.1"
val grpcVersion = "1.42.1"
val kotlinVersion = "1.5.31"
val kotlinCoroutineVersion = "1.5.2"

repositories {
    mavenCentral()
}

plugins {
    application
    idea
    java
    val kotlinVersion = "1.5.31"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.serialization") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
    id("com.google.protobuf") version "0.8.17"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("org.jetbrains.kotlin.kapt") version kotlinVersion
}

application {
    mainClass.set("br.com.cinema.server.ApplicationKt")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${kotlinCoroutineVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${kotlinCoroutineVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.3.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}")
    implementation("com.google.guava:listenablefuture:1.0")
    implementation("org.slf4j:slf4j-simple:1.7.32")
    implementation("javax.inject:javax.inject:1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("io.grpc:grpc-protobuf-lite:${grpcVersion}")
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
    implementation("io.grpc:grpc-netty:${grpcVersion}")
    implementation("io.grpc:grpc-kotlin-stub-lite:1.0.0")
    implementation("com.google.protobuf:protobuf-java:${protobufVersion}")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.11.4"   //TODO needs to be bumped!
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.25.0" //TODO needs to be bumped!
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:0.2.0:jdk7@jar"//TODO needs to be bumped!
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach {
            it.generateDescriptorSet = true
            it.descriptorSetOptions.includeImports = true
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}
