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

        register("codelab.compose.android") {
            id = "codelab.compose.android"
            implementationClass = "plugin.compose.ComposeAndroidPlugin"
        }
    }
}
