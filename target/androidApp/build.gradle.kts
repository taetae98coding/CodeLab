plugins {
    id("codelab.android.app")
    id("codelab.compose.android")
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

    implementation(libs.material)
    implementation(libs.activity.compose)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
}
