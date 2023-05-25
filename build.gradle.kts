plugins {
    kotlin("jvm") version "1.8.20"
}

group = "me.fan87"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.eclipsesource.minimal-json:minimal-json:0.9.5")
    implementation(files("lib/leetcode-stdlib.jar"))
    testImplementation(kotlin("test"))
    implementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}