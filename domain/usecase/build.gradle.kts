plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":domain:entity"))
                implementation(project(":domain:exception"))
                implementation(project(":domain:repository"))
                implementation(project(":library:inject"))

                implementation(libs.coroutines.core)
                implementation(libs.paging.common)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.domain.usecase"
}
