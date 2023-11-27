package com.taetae98.codelab.navigation.core.poke

import com.arkivanov.decompose.ComponentContext

public class PokeListEntry(
    context: ComponentContext,
    public val onNavigateUp: () -> Unit,
    public val onNavigateToPokePage: (Int) -> Unit
) : ComponentContext by context
