package com.taetae98.codelab.navigation.core.poke

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.taetae98.codelab.navigation.core.Parameter

public data object PokePageEntry {
    private const val PREFIX = "${PokeEntry.PREFIX}/page?"
    public const val ROUTE: String = "$PREFIX${Parameter.INITIAL_INDEX}={${Parameter.INITIAL_INDEX}}"

    public val argument: List<NamedNavArgument> = listOf(
        navArgument(Parameter.INITIAL_INDEX) {
            type = NavType.IntType
            defaultValue = 0
        }
    )

    public fun getRoute(initialIndex: Int): String {
        return "$PREFIX${Parameter.INITIAL_INDEX}=$initialIndex"
    }
}
