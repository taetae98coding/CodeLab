package io.github.taetae98coding.codelab.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

public data object CodeLabTheme {
    val typography: Typography
        @Composable
        get() = MaterialTheme.typography
}

@Composable
public fun CodeLabTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = if (isSystemInDarkTheme()) {
        codeLabDarkColorScheme()
    } else {
        codeLabLightColorScheme()
    }

    MaterialExpressiveTheme(
        colorScheme = colorScheme,
        content = content,
    )
}
