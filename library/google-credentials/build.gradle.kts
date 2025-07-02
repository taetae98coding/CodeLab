import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.plugin.serialization)
}

kotlin {
    jvmToolchain(21)
    explicitApi()

    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm()
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
    applyDefaultHierarchyTemplate()

    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.android.googleid)
                implementation(libs.androidx.credentials)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.ktor.client.okhttp)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.server.cio)
            }
        }
    }
}

android {
    namespace = "io.github.taetae98coding.codelab.google.credentials"

    defaultConfig {
        compileSdk = 36
        minSdk = 33
    }
}
