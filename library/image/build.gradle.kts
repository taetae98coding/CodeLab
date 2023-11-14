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
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.image"
}
