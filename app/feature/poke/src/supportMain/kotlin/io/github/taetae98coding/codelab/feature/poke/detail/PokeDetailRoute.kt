package io.github.taetae98coding.codelab.feature.poke.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun PokeDetailRoute(
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PokeDetailDialog(
        onDismissRequest = navigateUp
    )
}
