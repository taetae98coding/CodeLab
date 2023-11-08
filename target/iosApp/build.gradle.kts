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
            isStatic = true

            export(project(":navigation:core"))
            export(libs.decompose)
            export(libs.essenty.lifecycle)
        }
    }

    sourceSets {
        iosMain {
            dependencies {
                implementation(project(":app"))
                implementation(compose.ui)

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)

                api(project(":navigation:core"))
                api(libs.decompose)
                api(libs.essenty.lifecycle)
            }
        }
    }
}
