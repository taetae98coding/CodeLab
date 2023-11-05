plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
                implementation(project(":data:dto"))
                implementation(project(":data:local"))
                implementation(project(":domain:entity"))
                implementation(project(":domain:repository"))
            }
        }

        androidMain {
            dependencies {
                implementation(libs.hilt.android)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.repository"
}

dependencies {
    kspAndroid(libs.hilt.compiler)
}
