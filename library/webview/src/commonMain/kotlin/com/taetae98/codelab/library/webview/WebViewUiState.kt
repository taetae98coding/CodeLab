package com.taetae98.codelab.library.webview

import androidx.compose.runtime.Immutable

@Immutable
public sealed class WebViewUiState {
    public data class Url(val url: String) : WebViewUiState()

    public data class Html(
        val html: String,
        val baseUrl: String? = null
    ) : WebViewUiState()
}
