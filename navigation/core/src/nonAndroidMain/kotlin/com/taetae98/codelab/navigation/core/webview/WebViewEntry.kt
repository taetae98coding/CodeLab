package com.taetae98.codelab.navigation.core.webview

import com.arkivanov.decompose.ComponentContext

public class WebViewEntry(
    context: ComponentContext,
    public val onNavigateUp: () -> Unit,
)
