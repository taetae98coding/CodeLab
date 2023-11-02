plugins {
    id("codelab.multiplatform")
    id("codelab.compose.android")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":navigation:compose"))

                implementation(libs.kotlin.immutable)
                implementation(compose.material3)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.navigation.compose)
                implementation(compose.uiTooling)
            }
        }
        
        nonAndroidMain {
            dependencies {
                implementation(libs.decompose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.main"
}
