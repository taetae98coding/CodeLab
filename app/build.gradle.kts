plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.application)
}

kotlin {
    jvmToolchain(21)
    explicitApi()

    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { target ->
        target.binaries {
            framework {
                baseName = "CodeLabCompose"
            }
        }
    }

    jvm()

    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "codelab-compose.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        all {
            languageSettings.optIn("androidx.compose.ui.ExperimentalComposeUiApi")
            languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3ExpressiveApi")
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.material3)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.android.material)
                implementation(libs.androidx.activity.compose)
            }
        }

        jvmMain {
            dependencies {
                runtimeOnly(compose.desktop.currentOs)
            }
        }
    }
}

android {
    namespace = "io.github.taetae98coding.codelab"

    defaultConfig {
        applicationId = "io.github.taetae98coding.codelab"

        compileSdk = 36
        minSdk = 33
    }
}
