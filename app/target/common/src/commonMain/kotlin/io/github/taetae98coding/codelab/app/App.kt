package io.github.taetae98coding.codelab.app

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.util.DebugLogger
import io.github.taetae98coding.codelab.core.navigation.poke.PokeHome
import io.github.taetae98coding.codelab.feature.poke.pokeNavigation

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
public fun App() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .logger(DebugLogger())
            .build()
    }

    MaterialTheme {
        SharedTransitionLayout {
            val sharedTransitionScope = this
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = PokeHome,
            ) {
                pokeNavigation(
                    navController = navController,
                    sharedTransitionScope = sharedTransitionScope,
                )
            }
        }
    }
}
