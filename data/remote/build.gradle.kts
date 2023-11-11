plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
                implementation(project(":data:dto"))
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.remote"
}
