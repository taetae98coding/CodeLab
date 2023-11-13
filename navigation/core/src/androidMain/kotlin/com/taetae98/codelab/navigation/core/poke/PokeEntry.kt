package com.taetae98.codelab.navigation.core.poke

import com.taetae98.codelab.navigation.core.AppEntry

public data object PokeEntry {
    internal const val PREFIX: String = "${AppEntry.PREFIX}/poke"
    public const val ROUTE: String = PREFIX
}
