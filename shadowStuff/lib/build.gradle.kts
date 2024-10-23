plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
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

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api(libs.commons.math3)

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

// Configure the ShadowJar task (optional customization)
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    // Optionally, set the name of the generated jar file
    archiveFileName.set("shadow.jar")
}