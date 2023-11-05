plugins {
    id("codelab.android.app")
    id("codelab.hilt.android")
//    id("codelab.compose.android")
    alias(libs.plugins.compose.multiplatform)
}

android {
    namespace = Build.NAMESPACE

    defaultConfig {
        applicationId = Build.NAMESPACE
        versionCode = 10000
        versionName = "1.0.0"
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":navigation:core"))

    implementation(libs.material)
    implementation(libs.activity.compose)

//    implementation(platform(libs.compose.bom))
//    implementation(libs.compose.ui)
    implementation(compose.ui)
}
