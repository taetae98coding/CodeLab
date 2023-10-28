package com.taetae98.codelab.navigation.core.webview

import com.arkivanov.decompose.ComponentContext

public class WebViewEntry(
    context: ComponentContext,
    private val onNavigateUp: () -> Unit,
)
