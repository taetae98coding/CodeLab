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
                implementation(libs.androidx.navigation3.runtime)
            }
        }

        val nonAndroidMain = create("nonAndroidMain") {
            dependencies {
                implementation(libs.kotlinx.serialization.core)
            }
        }

        nonAndroidMain.dependsOn(commonMain.get())
        iosMain.get().dependsOn(nonAndroidMain)
        jvmMain.get().dependsOn(nonAndroidMain)
        wasmJsMain.get().dependsOn(nonAndroidMain)
    }
}

android {
    namespace = "io.github.taetae98coding.codelab.core.navigation"

    defaultConfig {
        compileSdk = 36
        minSdk = 33
    }
}
