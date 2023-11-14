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

        nonMobileMain {
            dependencies {
                implementation(libs.ktor.core)
                implementation(compose.foundation)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.ktor.okhttp)
            }
        }

        jsMain {
            dependencies {
                implementation(libs.ktor.js)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.image"
}
