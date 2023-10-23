package com.taetae98.codelab.library.webview

import android.annotation.SuppressLint
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
public actual fun WebView(
    modifier: Modifier,
    uiState: WebViewUiState,
) {
    AndroidView(
        modifier = modifier,
        factory = {
            WebView(it).apply {
                initSetting()
                initClient()
            }
        },
        update = {
            when (uiState) {
                is WebViewUiState.Url -> it.loadUrl(uiState.url)
                is WebViewUiState.Data -> it.loadData(uiState.data, "text/html", "utf-8")
            }
        },
    )
}

@SuppressLint("SetJavaScriptEnabled")
private fun WebView.initSetting() {
    settings.javaScriptEnabled = true
}

private fun WebView.initClient() {
    webViewClient = WebViewClient()
    webChromeClient = WebChromeClient()
}
