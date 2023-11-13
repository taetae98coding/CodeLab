package com.taetae98.codelab.navigation.compose.poke

import androidx.navigation.NavController
import com.taetae98.codelab.navigation.core.poke.PokeEntry

public fun NavController.navigateToPoke() {
    navigate(PokeEntry.ROUTE)
}
