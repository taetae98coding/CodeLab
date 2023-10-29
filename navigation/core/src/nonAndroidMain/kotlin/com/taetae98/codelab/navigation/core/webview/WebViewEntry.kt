package com.taetae98.codelab.navigation.core.webview

import com.taetae98.codelab.navigation.core.Entry

public class WebViewEntry(
    public val onNavigateUp: () -> Unit,
) : Entry()
