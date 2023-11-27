package com.taetae98.codelab.navigation.core

import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.json.JsonPrimitive

public open class Entry(
    context: ComponentContext
) : ComponentContext by context {
    public open val arguments: Map<String, JsonPrimitive> = emptyMap()
}
