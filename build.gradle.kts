plugins {
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.kotlin.plugin.compose).apply(false)
    alias(libs.plugins.kotlin.plugin.serialization).apply(false)

    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)

    alias(libs.plugins.compose.multiplatform).apply(false)

    alias(libs.plugins.buildkonfig).apply(false)
}
