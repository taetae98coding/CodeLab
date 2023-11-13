plugins {
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(17)
    explicitApi()
}

dependencies {
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.ksp.gradle)
    compileOnly(libs.android.gradle)
    compileOnly(libs.hilt.gradle)
    compileOnly(libs.compose.multiplatform.gradle)
}

gradlePlugin {
    plugins {
        register("codelab.android.app") {
            id = "codelab.android.app"
            implementationClass = "plugin.android.AndroidAppPlugin"
        }

        register("codelab.android.library") {
            id = "codelab.android.library"
            implementationClass = "plugin.android.AndroidLibraryPlugin"
        }

        register("codelab.ios") {
            id = "codelab.ios"
            implementationClass = "plugin.ios.IosPlugin"
        }

        register("codelab.jvm") {
            id = "codelab.jvm"
            implementationClass = "plugin.jvm.JvmPlugin"
        }

        register("codelab.web") {
            id = "codelab.web"
            implementationClass = "plugin.web.WebPlugin"
        }

        register("codelab.multiplatform") {
            id = "codelab.multiplatform"
            implementationClass = "plugin.multiplatform.MultiplatformPlugin"
        }

        register("codelab.feature") {
            id = "codelab.feature"
            implementationClass = "plugin.multiplatform.FeaturePlugin"
        }

        register("codelab.compose.android") {
            id = "codelab.compose.android"
            implementationClass = "plugin.compose.ComposeAndroidPlugin"
        }

        register("codelab.koin.multiplatform") {
            id = "codelab.koin.multiplatform"
            implementationClass = "plugin.koin.KoinMultiplatformPlugin"
        }

        register("codelab.hilt.android") {
            id = "codelab.hilt.android"
            implementationClass = "plugin.hilt.HiltAndroidPlugin"
        }

        register("codelab.hilt.multiplatform") {
            id = "codelab.hilt.multiplatform"
            implementationClass = "plugin.hilt.HiltMultiplatformPlugin"
        }
    }
}
