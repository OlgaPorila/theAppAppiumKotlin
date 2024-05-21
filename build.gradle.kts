plugins {
    kotlin("jvm") version "1.9.23"
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.appium:java-client:7.6.0")
    implementation("org.seleniumhq.selenium:selenium-remote-driver:3.141.59")
    implementation("org.seleniumhq.selenium:selenium-support:3.141.59")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0-M1")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.0-M1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.0-M1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}