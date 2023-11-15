package com.taetae98.codelab.navigation.core.poke

import com.arkivanov.decompose.ComponentContext
import com.taetae98.codelab.navigation.core.Entry
import kotlinx.serialization.json.JsonPrimitive

public class PokePageEntry(
    context: ComponentContext,
    initialIndex: Int,
    public val onNavigateUp: () -> Unit,
) : Entry(context) {
    override val arguments: Map<String, JsonPrimitive> = mapOf("init" to JsonPrimitive(initialIndex))
}