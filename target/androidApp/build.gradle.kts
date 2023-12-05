import org.jetbrains.compose.internal.utils.getLocalProperty

plugins {
    id("codelab.android.app")
    id("codelab.hilt.android")

    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.google.service)
}

android {
    namespace = Build.NAMESPACE

    defaultConfig {
        applicationId = Build.NAMESPACE
        versionCode = 10000
        versionName = "1.0.0"
    }

    signingConfigs {
        create("debugKey") {
            storeFile = file("keystore/debug.jks")
            storePassword = getLocalProperty("debug.key.store.password")
            keyAlias = getLocalProperty("debug.key.alias")
            keyPassword = getLocalProperty("debug.key.password")
        }

        create("releaseKey") {
            storeFile = file("keystore/release.jks")
            storePassword = getLocalProperty("release.key.store.password")
            keyAlias = getLocalProperty("release.key.alias")
            keyPassword = getLocalProperty("release.key.password")
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName("debugKey")
        }

        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("releaseKey")

            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":navigation:core"))

    implementation(libs.material)
    implementation(libs.activity.compose)

    implementation(compose.ui)
    compileOnly(compose.uiTooling)
}
