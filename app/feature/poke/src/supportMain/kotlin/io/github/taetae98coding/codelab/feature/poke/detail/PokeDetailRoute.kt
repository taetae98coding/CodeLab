package io.github.taetae98coding.codelab.feature.poke.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun PokeDetailRoute(
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokeDetailViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PokeDetailDialog(
        onDismissRequest = navigateUp,
        uiStateProvider = { uiState },
    )
}
