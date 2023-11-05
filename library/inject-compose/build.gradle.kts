plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:lifecycle"))
                implementation(compose.runtime)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.compose)
                implementation(libs.decompose)
                implementation(libs.kotlin.serialization)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.inject.compose"
}
