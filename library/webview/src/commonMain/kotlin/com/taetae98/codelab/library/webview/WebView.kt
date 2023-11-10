package com.taetae98.codelab.library.webview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
public expect fun WebView(modifier: Modifier = Modifier, uiState: WebViewUiState)
