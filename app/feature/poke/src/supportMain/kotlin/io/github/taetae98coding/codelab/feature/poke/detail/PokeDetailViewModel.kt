package io.github.taetae98coding.codelab.feature.poke.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import io.github.taetae98coding.codelab.core.navigation.poke.PokeDetail
import io.github.taetae98coding.codelab.domain.poke.usecase.GetPokeDetailUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import org.koin.android.annotation.KoinViewModel

@OptIn(ExperimentalCoroutinesApi::class)
@KoinViewModel
internal class PokeDetailViewModel(
    savedStateHandle: SavedStateHandle,
    getPokeDetailUseCase: GetPokeDetailUseCase,
) : ViewModel() {
    private val route = savedStateHandle.toRoute<PokeDetail>()

    private val detailRetryFlow = MutableStateFlow(0)
    val uiState = getPokeDetailUseCase(route.id)
        .mapLatest {
            it.fold(
                onSuccess = { PokeDetailUiState.State(it) },
                onFailure = { PokeDetailUiState.Error(::retry) },
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PokeDetailUiState.Loading,
        )

    private fun retry() {
        detailRetryFlow.value++
    }
}
