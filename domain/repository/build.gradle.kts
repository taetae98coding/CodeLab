plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":domain:entity"))
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.domain.repository"
}
