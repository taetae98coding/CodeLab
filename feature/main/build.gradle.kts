plugins {
    id("codelab.multiplatform")
    id("codelab.compose.android")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":navigation:compose"))

                implementation(libs.kotlin.immutable)
                implementation(compose.material3)
            }
        }

        getByName("androidMain") {
            dependencies {
                implementation(libs.navigation.compose)
                implementation(compose.uiTooling)
            }
        }

        getByName("nonAndroidMain") {
            dependencies {
                implementation(libs.decompose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.main"
}
