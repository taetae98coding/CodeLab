plugins {
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.kotlin.jvm).apply(false)
    alias(libs.plugins.kotlin.cocoapods).apply(false)

    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)

    alias(libs.plugins.compose.multiplatform).apply(false)

    alias(libs.plugins.spotless)
}

subprojects {
    plugins.apply("com.diffplug.spotless")

    spotless {
        kotlin {
            target("**/*.kt")
            ktlint()
            endWithNewline()
            indentWithSpaces()
            trimTrailingWhitespace()
        }
    }

    afterEvaluate {
        runCatching { tasks.getByPath("preBuild").dependsOn(tasks.spotlessApply) }
    }
}
