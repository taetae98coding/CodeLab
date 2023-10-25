plugins {
    id("codelab.ios")
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
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
                implementation(compose.foundation)
            }
        }
    }
}
