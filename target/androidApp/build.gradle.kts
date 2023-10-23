plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application)
}

kotlin {
    explicitApi()
    jvmToolchain(17)
}

android {
    namespace = "com.taetae98.codelab"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.taetae98.codelab"
        minSdk = 27
        targetSdk = 34
        versionCode = 10000
        versionName = "1.0.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    implementation(project(":app"))

    implementation(libs.material)
    implementation(libs.activity.compose)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
}