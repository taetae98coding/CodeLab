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
                implementation(project(":compose"))
                implementation(compose.material3)
            }
        }

        getByName("androidMain") {
            dependencies {
                implementation(compose.uiTooling)
            }
        }

        getByName("nonAndroidMain") {
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