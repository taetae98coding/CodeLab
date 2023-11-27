package com.taetae98.codelab.navigation.core.memo

import com.arkivanov.decompose.ComponentContext

public class MemoListEntry(
    context: ComponentContext,
    public val onNavigateUp: () -> Unit,
    public val onNavigateToMemoAdd: () -> Unit
) : ComponentContext by context
