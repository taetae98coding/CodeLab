
plugins {
    id("codelab.multiplatform")
    id("codelab.hilt.multiplatform")
    id("codelab.koin.multiplatform")
    id("codelab.kotest.multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
                implementation(project(":data:dto"))

                implementation(libs.bundles.ktor)
                implementation(libs.kotlin.serialization)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.ktor.mock)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.ktor.okhttp)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.ktor.darwin)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.ktor.okhttp)
            }
        }

        jvmTest {
            dependencies {
                implementation(libs.kotest.koin)
                implementation(libs.koin.test)
            }
        }

        jsMain {
            dependencies {
                implementation(libs.ktor.js)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.remote"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    kspAndroidTest(libs.hilt.compiler)
}
