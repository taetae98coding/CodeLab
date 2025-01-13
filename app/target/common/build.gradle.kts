plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
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
//    linuxX64()
//    linuxArm64()
//    watchosSimulatorArm64()
//    watchosX64()
//    watchosArm32()
//    watchosArm64()
//    tvosSimulatorArm64()
//    tvosX64()
//    tvosArm64()

    // Native Tier3
//    androidNativeArm32()
//    androidNativeArm64()
//    androidNativeX86()
//    androidNativeX64()
//    mingwX64()
//    watchosDeviceArm64()

    // Wasm
    wasmJs {
        browser()
    }

    // JavaScript
    js {
        browser()
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":app:core:navigation"))
                implementation(project(":app:core:poke-service"))
                implementation(project(":app:feature:poke"))

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                implementation(project.dependencies.platform(libs.koin.annotations.bom))
                implementation(libs.koin.annotations)

                implementation(compose.material3)
                implementation(libs.navigation.compose)


                implementation(project.dependencies.platform(libs.coil.bom))
                implementation(libs.coil.compose)
                implementation(libs.coil.ktor)
            }
        }

        jvmMain {
            dependencies {
                implementation(project(":app:data:poke"))
                implementation(project(":app:domain:poke"))
            }
        }

        androidMain {
            dependencies {
                implementation(project(":app:data:poke"))
                implementation(project(":app:domain:poke"))
            }
        }

        appleMain {
            dependencies {
                implementation(project(":app:data:poke"))
                implementation(project(":app:domain:poke"))
            }
        }
    }
}

android {
    namespace = "io.github.taetae98coding.codelab.app"

    defaultConfig {
        compileSdk = 35
    }
}

dependencies {
    ksp(platform(libs.koin.annotations.bom))
    ksp(libs.koin.compiler)
}
