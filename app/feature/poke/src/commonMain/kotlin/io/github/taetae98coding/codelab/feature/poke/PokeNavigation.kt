package io.github.taetae98coding.codelab.feature.poke

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

@OptIn(ExperimentalSharedTransitionApi::class)
public expect fun NavGraphBuilder.pokeNavigation(
    navController: NavController,
    sharedTransitionScope: SharedTransitionScope,
)
