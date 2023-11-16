plugins {
    id("codelab.multiplatform")
    id("codelab.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.ui)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.coil.compose)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(libs.ktor.core)
                implementation(compose.foundation)
            }
        }

        iosMain {
            dependencies {
                runtimeOnly(libs.ktor.darwin)
            }
        }

        jvmMain {
            dependencies {
                runtimeOnly(libs.ktor.okhttp)
            }
        }

        jsMain {
            dependencies {
                runtimeOnly(libs.ktor.js)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.image"
}
