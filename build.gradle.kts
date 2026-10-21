import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "com.thewind"
version = providers.gradleProperty("releaseVersion").orElse("1.0.0").get()

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    // Material icon artifacts are no longer pulled in transitively by Compose Desktop.
    implementation(compose.materialIconsExtended)
    implementation("org.javassist:javassist:3.29.2-GA")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.xerial:sqlite-jdbc:3.43.2.0")
    implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            // jpackage builds native installers on their respective operating systems.
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ByteMate"
            packageVersion = project.version.toString()
            description = "ByteMate desktop binary analysis utilities"
            vendor = "ByteMate contributors"
        }
    }
}
