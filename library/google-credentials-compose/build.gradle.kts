import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.library)
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
        commonMain {
            dependencies {
                implementation(compose.runtime)

                api(projects.library.googleCredentials)
            }
        }

        androidMain {
            dependencies {
                implementation(compose.ui)
                implementation(libs.android.googleid)
                implementation(libs.androidx.credentials)
            }
        }

        val unsupportedMain = create("unsupportedMain")

        unsupportedMain.dependsOn(commonMain.get())
        iosMain.get().dependsOn(unsupportedMain)
        wasmJsMain.get().dependsOn(unsupportedMain)
    }
}

android {
    namespace = "io.github.taetae98coding.codelab.google.credentials.compose"

    defaultConfig {
        compileSdk = 36
        minSdk = 33
    }
}
