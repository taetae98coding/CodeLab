package com.taetae98.codelab.navigation.core.memo

import com.arkivanov.decompose.ComponentContext

public class MemoAddEntry(
    context: ComponentContext,
    public val onNavigateUp: () -> Unit
) : ComponentContext by context
