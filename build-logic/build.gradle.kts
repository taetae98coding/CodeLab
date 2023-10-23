plugins {
    `kotlin-dsl`
}

kotlin {
    jvmToolchain(17)
    explicitApi()
}

dependencies {
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.android.gradle)
}

gradlePlugin {
    plugins {
        register("codelab.android.app") {
            id = "codelab.android.app"
            implementationClass = "plugin.android.AndroidAppPlugin"
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

        register("codelab.compose.android") {
            id = "codelab.compose.android"
            implementationClass = "plugin.compose.ComposeAndroidPlugin"
        }
    }
}
