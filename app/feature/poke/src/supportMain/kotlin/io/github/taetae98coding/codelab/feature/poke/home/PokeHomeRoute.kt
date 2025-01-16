package io.github.taetae98coding.codelab.feature.poke.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.taetae98coding.codelab.library.paging.compose.runtime.collectAsLazyPagingItems
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun PokeHomeRoute(
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokeHomeViewModel = koinViewModel(),
) {
    val pagingItems = viewModel.paging.collectAsLazyPagingItems()

    PokeHomeScaffold(
        modifier = modifier,
        onPoke = navigateToDetail,
        pagingItems = pagingItems,
    )
}
