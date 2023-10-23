package com.taetae98.codelab.feature.webview

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.library.webview.WebView
import com.taetae98.codelab.library.webview.WebViewUiState

@Composable
internal fun WebViewScreen(
    modifier: Modifier = Modifier,
    webViewUiState: WebViewUiState,
) {
    Scaffold(
        modifier = modifier,
    ) {
        WebView(
            modifier = Modifier.padding(it),
            uiState = webViewUiState,
        )
    }
}
