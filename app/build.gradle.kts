import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    val isPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    val iosTarget: (String) -> KotlinNativeTarget = if (isPhone) ::iosArm64 else ::iosSimulatorArm64

    explicitApi()
    jvmToolchain(17)

    androidTarget()
    iosTarget("ios")
    jvm()
    js(IR) {
        browser()
    }

    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(compose.material3)
            }
        }
    }
}

android {
    namespace = "com.taetae98.codelab.app"

    compileSdk = 34
    defaultConfig {
        minSdk = 27
    }
}
