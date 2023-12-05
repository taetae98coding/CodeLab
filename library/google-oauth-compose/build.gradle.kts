plugins {
    id("codelab.multiplatform")
    id("codelab.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(project(":library:google-oauth"))
            }
        }

        androidMain {
            dependencies {
                implementation(libs.activity.compose)
            }
        }

        iosMain {
            dependencies {
                implementation(compose.ui)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.google.oauth.compose"
}
