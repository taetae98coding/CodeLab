plugins {
    alias(libs.plugins.kotlin.multiplatform)
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
                implementation(project(":library:paging-common"))
                implementation(compose.runtime)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.androidx.paging.compose)
            }
        }

        val nonAndroidMain = create("nonAndroidMain") {
            dependencies {
                implementation(project(":library:paging-common"))
            }
        }

        nonAndroidMain.dependsOn(commonMain.get())

        jvmMain.get().dependsOn(nonAndroidMain)
        appleMain.get().dependsOn(nonAndroidMain)
        linuxMain.get().dependsOn(nonAndroidMain)
    }
}

android {
    namespace = "io.github.taetae98coding.codelab.library.paging.compose"

    defaultConfig {
        compileSdk = 35
    }
}
