package com.taetae98.codelab.feature.poke

import app.cash.paging.PagingData
import app.cash.paging.cachedIn
import app.cash.paging.map
import com.taetae98.codelab.domain.usecase.poke.PagePokeUseCase
import com.taetae98.codelab.library.lifecycle.KViewModel
import kotlinx.coroutines.flow.mapLatest
import org.koin.core.annotation.Factory

@Factory
internal open class PokeListViewModel(
    pagePokeUseCase: PagePokeUseCase,
) : KViewModel() {
    private val paging = pagePokeUseCase(PagePokeUseCase.Params(0))
        .mapLatest { it.getOrDefault(PagingData.empty()) }
        .cachedIn(kViewModelScope)

    val pokeUiState = paging.mapLatest { pagingData ->
        pagingData.map {
            PokeUiState(
                id = it.id,
                name = it.name,
                image = it.image,
            )
        }
    }
}
