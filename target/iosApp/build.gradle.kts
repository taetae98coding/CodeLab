import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    explicitApi()
    jvmToolchain(17)

    val isPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    val iosTarget: (String) -> KotlinNativeTarget = if (isPhone) ::iosArm64 else ::iosSimulatorArm64

    iosTarget("ios")

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0.0"
        ios.deploymentTarget = "17.0"
        podfile = project.file("../../ios/Podfile")
        framework {
            baseName = "iosApp"
        }
    }

    sourceSets {
        getByName("iosMain") {
            dependencies {
                implementation(project(":app"))
                implementation(compose.ui)
            }
        }
    }
}

