import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.jetbrains.compose.internal.utils.getLocalProperty
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.plugin.compose)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.buildkonfig)
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

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "codelab-compose.js"
            }
        }
        binaries.executable()
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        all {
            languageSettings.optIn("androidx.compose.ui.ExperimentalComposeUiApi")
            languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3ExpressiveApi")
            languageSettings.optIn("androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi")
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.compose)
                implementation(projects.core.navigation)
                implementation(projects.library.googleCredentials)
                implementation(projects.feature.auth)
                implementation(projects.feature.home)
                implementation(compose.ui)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.android.material)
                implementation(libs.androidx.activity.compose)
                implementation(libs.androidx.navigation3.ui)
                implementation(libs.androidx.material3.adaptive.navigation3)
                implementation(libs.androidx.startup)
            }
        }

        jvmMain {
            dependencies {
                runtimeOnly(compose.desktop.currentOs)
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
    namespace = "io.github.taetae98coding.codelab"

    defaultConfig {
        applicationId = "io.github.taetae98coding.codelab"

        compileSdk = 36
        minSdk = 33

        versionCode = 1
        versionName = "1.0.0"
    }

    signingConfigs {
        create("dev") {
            storeFile = file("keystore/android-dev.jks")
            storePassword = getLocalProperty("dev.android.key.store.password")
            keyAlias = getLocalProperty("dev.android.key.alias")
            keyPassword = getLocalProperty("dev.android.key.password")
        }
    }

    flavorDimensions("product")
    productFlavors {
        create("dev") {
            applicationIdSuffix = ".dev"
            signingConfig = signingConfigs.getByName("dev")
        }
    }

    buildTypes {
        debug {
            signingConfig = null
        }

        release {
            signingConfig = null
        }
    }
}

buildkonfig {
    packageName = "io.github.taetae98coding.coedlab"

    defaultConfigs {
    }

    targetConfigs {
        create("android") {
            buildConfigField(
                type = FieldSpec.Type.STRING,
                name = "GOOGLE_CLIENT_ID",
                value = getLocalProperty("dev.google.client.id") as String,
                nullable = false,
                const = true,
            )
        }

        create("jvm") {
            buildConfigField(
                type = FieldSpec.Type.STRING,
                name = "GOOGLE_REDIRECT_URI",
                value = getLocalProperty("dev.google.redirect.uri") as String,
                nullable = false,
                const = true,
            )

            buildConfigField(
                type = FieldSpec.Type.STRING,
                name = "GOOGLE_CLIENT_ID",
                value = getLocalProperty("dev.google.client.id") as String,
                nullable = false,
                const = true,
            )

            buildConfigField(
                type = FieldSpec.Type.STRING,
                name = "GOOGLE_CLIENT_SECRET",
                value = getLocalProperty("dev.google.client.secret") as String,
                nullable = false,
                const = true,
            )
        }
    }
}
