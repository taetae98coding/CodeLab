package com.taetae98.codelab.feature.poke

import app.cash.paging.PagingData
import app.cash.paging.cachedIn
import app.cash.paging.map
import com.taetae98.codelab.domain.entity.PokeDetail
import com.taetae98.codelab.domain.entity.PokeId
import com.taetae98.codelab.domain.usecase.poke.GetPokeDetailUseCase
import com.taetae98.codelab.domain.usecase.poke.PagePokeUseCase
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import com.taetae98.codelab.library.lifecycle.KViewModel
import com.taetae98.codelab.navigation.core.Parameter
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory

@Factory
internal open class PokePageViewModel(
    kSavedStateHandle: KSavedStateHandle,
    pagePokeUseCase: PagePokeUseCase,
    private val getPokeDetailUseCase: GetPokeDetailUseCase,
) : KViewModel() {
    val initialIndex = kSavedStateHandle.getStateFlow(Parameter.INITIAL_INDEX, 0)

    private val pagingData = pagePokeUseCase(PagePokeUseCase.Params(initialIndex.value))
        .mapLatest { it.getOrDefault(PagingData.empty()) }
        .cachedIn(kViewModelScope)

    private val detailMap = MutableStateFlow<Map<PokeId, PokeDetail>>(emptyMap())


    val pokeUiState = combine(
        pagingData,
        detailMap,
    ) { pagingData, detailMap ->
        pagingData.map {
            if (!detailMap.contains(PokeId(it.id))) {
                PokeDetailUiState.Loading(
                    id = it.id,
                    name = it.name,
                    fetch = ::fetchDetail,
                )
            } else {
                PokeDetailUiState.Detail(
                    id = it.id,
                    name = it.name,
                    imageList = detailMap[PokeId(it.id)]?.imageList.orEmpty().toImmutableList()
                )
            }
        }
    }.cachedIn(kViewModelScope)

    private fun fetchDetail(id: Int) {
        kViewModelScope.launch {
            getPokeDetailUseCase(PokeId(id)).onSuccess {
                detailMap.emit(
                    buildMap {
                        putAll(detailMap.value)
                        put(PokeId(id), it)
                    }
                )
            }
        }
    }
}