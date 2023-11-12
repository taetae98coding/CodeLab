plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.kotest.multiplatform)
}

android {
    namespace = "${Build.NAMESPACE}.data.dto"
}
