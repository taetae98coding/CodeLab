plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    alias(libs.plugins.kotest.multiplatform)
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

        commonTest {
            dependencies {
                implementation(libs.kotest.framework)
                implementation(libs.kotest.assertions)
                implementation(libs.kotest.property)
            }
        }

        jvmTest {
            dependencies {
                implementation(libs.kotest.junit5)
                implementation(libs.mockk)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.domain.usecase"
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}