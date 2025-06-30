package io.github.taetae98coding.codelab.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.runtime.Composable

@Composable
public fun CodeLabTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = if (isSystemInDarkTheme()) {
        codeLabLightColorScheme()
    } else {
        codeLabDarkColorScheme()
    }

    MaterialExpressiveTheme(
        colorScheme = colorScheme,
        content = content,
    )
}
