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
