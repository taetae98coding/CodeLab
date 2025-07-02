package io.github.taetae98coding.codelab.compose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
internal actual fun codeLabLightColorScheme(): ColorScheme {
    return dynamicLightColorScheme(LocalContext.current)
}

@Composable
internal actual fun codeLabDarkColorScheme(): ColorScheme {
    return dynamicDarkColorScheme(LocalContext.current)
}
