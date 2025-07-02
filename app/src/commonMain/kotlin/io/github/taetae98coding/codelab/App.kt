package io.github.taetae98coding.codelab

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.taetae98coding.codelab.compose.theme.CodeLabTheme

@Composable
public fun App() {
    CodeLabTheme {
        AppNavigation(
            modifier = Modifier.fillMaxSize()
                .imePadding(),
        )
    }
}
