pluginManagement {
    val quarkusPluginVersion: String by settings
    val quarkusPluginId: String by settings
    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
    plugins {
        id(quarkusPluginId) version quarkusPluginVersion
        id("org.gradle.toolchains.foojay-resolver-convention") version " 0.7.0"
    }
}
rootProject.name = "kotlin-quarkus-jpa-api-demo"