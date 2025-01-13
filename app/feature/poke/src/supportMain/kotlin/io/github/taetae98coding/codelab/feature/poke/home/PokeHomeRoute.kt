package io.github.taetae98coding.codelab.feature.poke.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.taetae98coding.codelab.feature.poke.PokeViewModel
import io.github.taetae98coding.codelab.feature.poke.collectAsLazyPagingItems
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun PokeHomeRoute(
    modifier: Modifier = Modifier,
    viewModel: PokeViewModel = koinViewModel(),
) {
    val pagingItems = viewModel.paging.collectAsLazyPagingItems()

    PokeHomeScaffold(
        modifier = modifier,
        pagingItems = pagingItems,
    )
}
