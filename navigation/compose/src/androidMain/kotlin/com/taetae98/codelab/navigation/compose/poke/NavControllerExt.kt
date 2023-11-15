package com.taetae98.codelab.navigation.compose.poke

import androidx.navigation.NavController
import com.taetae98.codelab.navigation.core.poke.PokeEntry
import com.taetae98.codelab.navigation.core.poke.PokePageEntry

public fun NavController.navigateToPoke() {
    navigate(PokeEntry.ROUTE)
}

public fun NavController.navigateToPokePage(initialIndex: Int) {
    navigate(PokePageEntry.getRoute(initialIndex))
}
