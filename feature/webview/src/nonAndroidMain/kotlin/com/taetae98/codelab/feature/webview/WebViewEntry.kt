package com.taetae98.codelab.feature.webview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.navigation.core.webview.WebViewEntry

@Composable
public fun WebViewEntry(modifier: Modifier = Modifier, entry: WebViewEntry) {
    WebViewRoute(
        modifier = modifier,
        onNavigateUp = entry.onNavigateUp,
    )
}
