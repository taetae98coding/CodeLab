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
                implementation(compose.foundation)
            }
        }
    }
}

compose.experimental {
    web.application
}
