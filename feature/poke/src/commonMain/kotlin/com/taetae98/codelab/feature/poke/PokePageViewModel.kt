package com.taetae98.codelab.feature.poke

import app.cash.paging.PagingData
import app.cash.paging.cachedIn
import com.taetae98.codelab.domain.usecase.poke.PagePokeUseCase
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import com.taetae98.codelab.library.lifecycle.KViewModel
import com.taetae98.codelab.library.paging.mapPagingLatest
import com.taetae98.codelab.navigation.core.const.Parameter
import kotlinx.coroutines.flow.mapLatest
import org.koin.core.annotation.Factory

@Factory
internal open class PokePageViewModel(
    kSavedStateHandle: KSavedStateHandle,
    pagePokeUseCase: PagePokeUseCase,
) : KViewModel() {
    val initialIndex = kSavedStateHandle.getStateFlow(Parameter.INITIAL_INDEX, 0)

    private val paging = pagePokeUseCase(PagePokeUseCase.Params(initialIndex.value))
        .mapLatest { it.getOrDefault(PagingData.empty()) }
        .cachedIn(kViewModelScope)


    val pokeUiState = paging.mapPagingLatest {
        PokeUiState(
            id = it.id,
            name = it.name,
            image = it.image,
        )
    }.cachedIn(kViewModelScope)
}