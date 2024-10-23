plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    // Apply the Shadow plugin for creating a fat jar.
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    implementation("com.google.guava:guava:33.3.1-jre")
    implementation("org.apache.commons:commons-lang3:3.17.0")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

// Configure the ShadowJar task (optional customization)
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    // Optionally, set the name of the generated jar file
    archiveFileName.set("myApp.jar")
    // Ensure the manifest has the correct main class
    manifest {
        attributes["Main-Class"] = "org.example.App"
    }
}