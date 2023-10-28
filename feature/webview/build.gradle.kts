plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":library:webview"))
                implementation(compose.material3)
            }
        }

        getByName("androidMain") {
            dependencies {
//                implementation(libs.navigation.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.webview"
}
