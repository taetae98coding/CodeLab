plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":domain:entity"))
                implementation(project(":domain:exception"))
                implementation(project(":domain:repository"))
                implementation(project(":library:inject"))
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.domain.usecase"
}
