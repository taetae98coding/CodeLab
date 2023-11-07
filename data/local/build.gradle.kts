plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":data:dto"))
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.local"
}
