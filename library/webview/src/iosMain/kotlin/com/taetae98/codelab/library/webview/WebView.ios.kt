package com.taetae98.codelab.library.webview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSURL
import platform.Foundation.NSURLRequest
import platform.WebKit.WKWebView

@OptIn(ExperimentalForeignApi::class)
@Composable
public actual fun WebView(modifier: Modifier, uiState: WebViewUiState) {
    UIKitView(
        modifier = modifier,
        factory = {
            WKWebView()
        },
        update = { webView ->
            when (uiState) {
                is WebViewUiState.Url -> webView.loadRequest(NSURLRequest(NSURL(string = uiState.url)))
                is WebViewUiState.Html -> webView.loadHTMLString(uiState.html, uiState.baseUrl?.let { NSURL(string = it) })
            }
        }
    )
}
