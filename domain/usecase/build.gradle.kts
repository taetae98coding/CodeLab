plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    id("codelab.kotest.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":domain:repository"))
                implementation(project(":library:inject"))

                implementation(project(":domain:entity"))
                implementation(project(":domain:exception"))

                implementation(libs.coroutines.core)
                implementation(libs.paging.common)
            }
        }

        jvmTest {
            dependencies {
                implementation(project(":domain:repository"))
                implementation(libs.mockk)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.domain.usecase"
}
