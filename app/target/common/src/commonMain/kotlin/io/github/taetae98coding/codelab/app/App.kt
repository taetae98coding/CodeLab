package io.github.taetae98coding.codelab.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.util.DebugLogger
import io.github.taetae98coding.codelab.feature.poke.pokeNavigation

@Composable
public fun App() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .logger(DebugLogger())
            .build()
    }

    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "poke",
        ) {
            pokeNavigation(navController = navController)
        }
    }
}
