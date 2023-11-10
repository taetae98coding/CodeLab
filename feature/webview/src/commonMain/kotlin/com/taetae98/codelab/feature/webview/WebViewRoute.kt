package com.taetae98.codelab.feature.webview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun WebViewRoute(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    WebViewScreen(
        modifier = modifier,
        onNavigateUp = onNavigateUp,
    )
}
