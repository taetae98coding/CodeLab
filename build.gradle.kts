plugins {
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.kotlin.jvm).apply(false)
    alias(libs.plugins.kotlin.cocoapods).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)

    alias(libs.plugins.javafx).apply(false)

    alias(libs.plugins.google.service).apply(false)

    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)

    alias(libs.plugins.compose.multiplatform).apply(false)
    alias(libs.plugins.sqldelight).apply(false)

    alias(libs.plugins.hilt).apply(false)
    alias(libs.plugins.room).apply(false)

    alias(libs.plugins.kotest.multiplatform).apply(false)

    alias(libs.plugins.spotless)
    alias(libs.plugins.ksp).apply(false)
    alias(libs.plugins.buildkonfig).apply(false)
}

subprojects {
    plugins.apply("com.diffplug.spotless")

    spotless {
        kotlin {
            target("**/*.kt")
            ktlint("1.0.1")
            endWithNewline()
            indentWithSpaces()
            trimTrailingWhitespace()
        }
    }

//    afterEvaluate {
//        runCatching { tasks.getByPath("preBuild").dependsOn(tasks.spotlessApply) }
//    }
}
