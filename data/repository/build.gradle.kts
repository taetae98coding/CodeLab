plugins {
    id("codelab.multiplatform")
    id("codelab.hilt.multiplatform")
    id("codelab.koin.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
                implementation(project(":data:dto"))
                implementation(project(":data:local"))
                implementation(project(":data:remote"))
                implementation(project(":domain:entity"))
                implementation(project(":domain:repository"))

                implementation(libs.coroutines.core)
                implementation(libs.paging.common)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.repository"
}
