package io.github.taetae98coding.codelab.feature.poke.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import io.github.taetae98coding.codelab.domain.poke.usecase.PagingPokeUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.mapLatest
import org.koin.android.annotation.KoinViewModel

@OptIn(ExperimentalCoroutinesApi::class)
@KoinViewModel
internal class PokeHomeViewModel(
    pagingPokeUseCase: PagingPokeUseCase,
) : ViewModel() {
    val paging = pagingPokeUseCase().mapLatest { it.getOrNull() }
        .mapLatest { it ?: PagingData.Companion.empty() }
        .cachedIn(viewModelScope)
}
