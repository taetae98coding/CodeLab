package com.taetae98.codelab.library.webview

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
public actual fun WebView(
    modifier: Modifier,
    uiState: WebViewUiState,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = uiState.toString(),
        )
    }
}
