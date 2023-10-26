package com.taetae98.codelab.feature.webview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.library.webview.WebViewUiState

@Composable
internal fun WebViewRoute(modifier: Modifier = Modifier) {
    WebViewScreen(
        modifier = modifier.fillMaxSize(),
        webViewUiState = WebViewUiState.Url("https://www.naver.com"),
    )
}
