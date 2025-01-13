plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.ksp)
    alias(libs.plugins.android.library)
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

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":app:core:poke-service"))
                implementation(project(":app:domain:poke"))

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                implementation(project.dependencies.platform(libs.koin.annotations.bom))
                implementation(libs.koin.annotations)
            }
        }
    }
}

android {
    namespace = "io.github.taetae98coding.codelab.data.poke"

    defaultConfig {
        compileSdk = 35
    }
}

dependencies {
    ksp(platform(libs.koin.annotations.bom))
    ksp(libs.koin.compiler)
}
