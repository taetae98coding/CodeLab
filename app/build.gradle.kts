plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":feature:main"))
                implementation(project(":feature:webview"))
                implementation(compose.material3)

                implementation(libs.decompose)
                implementation(libs.decompose.compose)
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
    namespace = "${Build.NAMESPACE}.app"
}
