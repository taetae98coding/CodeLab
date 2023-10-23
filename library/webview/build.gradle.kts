plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(compose.ui)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.webview"
}
