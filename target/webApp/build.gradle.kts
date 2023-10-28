plugins {
    id("codelab.web")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    js(IR) {
        binaries.executable()
    }

    sourceSets {
        getByName("jsMain") {
            dependencies {
                implementation(project(":app"))
                implementation(project(":navigation:core"))

                implementation(compose.ui)
                implementation(libs.decompose)
            }
        }
    }
}

compose.experimental {
    web.application
}
