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
        all {
            languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3Api")
            languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3ExpressiveApi")
            languageSettings.optIn("androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi")
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.compose)
                implementation(projects.core.navigation)
                implementation(compose.material3)
                implementation(compose.components.uiToolingPreview)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.navigation3.ui)
                implementation(libs.androidx.material3.adaptive.navigation3)
            }
        }

        val nonAndroidMain = create("nonAndroidMain") {
            dependencies {
                implementation(libs.navigation.compose)
            }
        }

        nonAndroidMain.dependsOn(commonMain.get())
        iosMain.get().dependsOn(nonAndroidMain)
        jvmMain.get().dependsOn(nonAndroidMain)
        wasmJsMain.get().dependsOn(nonAndroidMain)
    }
}

android {
    namespace = "io.github.taetae98coding.codelab.feature.home"

    defaultConfig {
        compileSdk = 36
        minSdk = 33
    }
}
