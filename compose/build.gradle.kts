import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
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
            languageSettings.optIn("androidx.compose.ui.ExperimentalComposeUiApi")
            languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3ExpressiveApi")
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.components.uiToolingPreview)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
            }
        }

        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        invokeWhenCreated("androidDebug") {
            dependencies {
                api(compose.uiTooling)
            }
        }

        val nonAndroidMain = create("nonAndroidMain")

        nonAndroidMain.dependsOn(commonMain.get())
        iosMain.get().dependsOn(nonAndroidMain)
        jvmMain.get().dependsOn(nonAndroidMain)
        wasmJsMain.get().dependsOn(nonAndroidMain)
    }
}

android {
    namespace = "io.github.taetae98coding.codelab.compose"

    defaultConfig {
        compileSdk = 36
        minSdk = 33
    }
}
