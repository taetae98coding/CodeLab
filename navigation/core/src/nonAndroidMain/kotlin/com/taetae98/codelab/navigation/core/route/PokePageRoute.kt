package com.taetae98.codelab.navigation.core.route

import kotlinx.serialization.Serializable

@Serializable
public data class PokePageRoute(
    val initialIndex: Int
) : Route