plugins {
    id("codelab.feature")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:webview"))
                implementation(compose.material3)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.webview"
}
