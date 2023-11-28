plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    id("codelab.hilt.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":data:preference"))
                implementation(project(":library:inject"))
                implementation(libs.coroutines.core)

            }
        }

        androidMain {
            dependencies {
                implementation(libs.datastore.preferences)
            }
        }

        nonJsMain {
            dependencies {
                implementation(libs.datastore.core)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.datastore"
}
