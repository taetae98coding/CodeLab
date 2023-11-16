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
    implementation(project(":data:local"))

    implementation(project(":data:dto"))

    implementation(libs.bundles.room)
    ksp(libs.room.compiler)

    implementation(libs.paging.common)
}

room {
    schemaDirectory("$projectDir/room/schemas/")
}
