plugins {
    id("org.jetbrains.compose") version "1.1.0-alpha03"
    id("com.android.application")
    kotlin("android")
}

group = "com.github.theapache64.pencilui"
version = "2022.2.6"

dependencies {
    implementation(project(":common-demo"))
    implementation("androidx.activity:activity-compose:1.4.0")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.github.theapache64.pencilui.demoandroid"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}