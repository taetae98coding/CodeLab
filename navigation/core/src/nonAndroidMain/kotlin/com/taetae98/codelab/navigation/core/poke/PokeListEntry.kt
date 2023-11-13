package com.taetae98.codelab.navigation.core.poke

import com.arkivanov.decompose.ComponentContext

public class PokeListEntry(
    context: ComponentContext,
    public val onNavigateUp: () -> Unit,
) : ComponentContext by context
