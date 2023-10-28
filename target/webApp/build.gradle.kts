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
                implementation(compose.ui)
            }
        }
    }
}

compose.experimental {
    web.application
}
