plugins {
    id("codelab.multiplatform")
    id("codelab.compose.android")
    alias(libs.plugins.compose.multiplatform)

    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":navigation:compose"))

                implementation(project(":domain:usecase"))

                implementation(project(":compose"))

                implementation(compose.material3)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.navigation.compose)
                implementation(libs.hilt.compose)
                implementation(compose.uiTooling)
                implementation(libs.hilt.android)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(libs.decompose)
                implementation(libs.decompose.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.memo"
}

dependencies {
    kspAndroid(libs.hilt.compiler)
}
