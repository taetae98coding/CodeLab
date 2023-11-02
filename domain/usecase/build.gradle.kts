plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.domain.usecase"
}
