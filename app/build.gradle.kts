plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":feature:main"))
                implementation(project(":feature:webview"))
                implementation(project(":feature:memo"))

                implementation(compose.material3)
                implementation(libs.decompose)
                implementation(libs.decompose.compose)
            }
        }

        androidMain {
            dependencies {
                implementation(project(":data:repository"))
                implementation(libs.navigation.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.app"
}
