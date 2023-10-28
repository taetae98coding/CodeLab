plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.javafx)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(compose.ui)
            }
        }

        getByName("jvmMain") {
            dependencies {
                val osSuffix = when (osdetector.classifier) {
                    "linux-x86_64" -> "linux"
                    "linux-aarch_64" -> "linux-aarch64"
                    "windows-x86_64" -> "win"
                    "osx-x86_64" -> "mac"
                    "osx-aarch_64" -> "mac-aarch64"
                    else -> throw IllegalStateException("Unknown OS: ${osdetector.classifier}")
                }

                implementation(compose.foundation)
                implementation("org.openjfx:javafx-base:22-ea+11:$osSuffix")
                implementation("org.openjfx:javafx-swing:22-ea+11:$osSuffix")
                implementation("org.openjfx:javafx-graphics:22-ea+11:$osSuffix")
                implementation("org.openjfx:javafx-web:22-ea+11:$osSuffix")
                implementation("org.openjfx:javafx-controls:22-ea+11:$osSuffix")
                implementation("org.openjfx:javafx-media:22-ea+11:$osSuffix")
            }
        }

        getByName("jsMain") {
            dependencies {
                implementation(compose.material3)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.webview"
}
