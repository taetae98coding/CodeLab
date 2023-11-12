plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
                implementation(project(":data:dto"))

                implementation(libs.ktor.core)
                implementation(libs.ktor.content.negotiation)
                implementation(libs.ktor.serialization)

                implementation(libs.kotlin.serialization)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotest.framework)
                implementation(libs.kotest.assertions)
                implementation(libs.kotest.property)

                implementation(libs.ktor.mock)
            }
        }

        jvmTest {
            dependencies {
                implementation(libs.kotest.junit5)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.remote"
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}
