package io.github.taetae98coding.codelab.compose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.expressiveLightColorScheme
import androidx.compose.runtime.Composable

@Composable
internal actual fun codeLabLightColorScheme(): ColorScheme {
    return expressiveLightColorScheme()
}

@Composable
internal actual fun codeLabDarkColorScheme(): ColorScheme {
    return darkColorScheme()
}
