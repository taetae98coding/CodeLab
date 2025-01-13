plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotest)
}

kotlin {
    explicitApi()
    jvmToolchain(17)

    // Android
    androidTarget()

    // JVM
    jvm()

    // Native Tier1
    macosX64()
    macosArm64()
    iosSimulatorArm64()
    iosX64()
    iosArm64()

    // Native Tier2
    linuxX64()
    linuxArm64()
    watchosSimulatorArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    tvosSimulatorArm64()
    tvosX64()
    tvosArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.androidx.paging.common)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.androidx.paging.testing)

                implementation(libs.kotest.engine)
                implementation(libs.kotest.assertions)
                implementation(libs.kotest.property)
            }
        }

        androidUnitTest {
            dependencies {
                implementation(libs.kotest.junit5)
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
    namespace = "io.github.taetae98coding.codelab.library.paging.common"

    defaultConfig {
        compileSdk = 35
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
