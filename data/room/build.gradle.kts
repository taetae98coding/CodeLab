plugins {
    id("codelab.android.library")
    id("codelab.hilt.android")
    alias(libs.plugins.room)
    alias(libs.plugins.ksp)
}

android {
    namespace = "${Build.NAMESPACE}.data.room"
}

dependencies {
    implementation(project(":data:dto"))
    implementation(project(":data:local"))

    implementation(libs.bundles.room)
    ksp(libs.room.compiler)
}

room {
    schemaDirectory("$projectDir/room/schemas/")
}
