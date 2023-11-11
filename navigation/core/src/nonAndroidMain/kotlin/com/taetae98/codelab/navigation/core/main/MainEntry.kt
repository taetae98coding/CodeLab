package com.taetae98.codelab.navigation.core.main

import com.arkivanov.decompose.ComponentContext

public class MainEntry(
    context: ComponentContext,
    public val onWebView: () -> Unit,
    public val onMemo: () -> Unit,
    public val onPoke: () -> Unit,
) : ComponentContext by context
