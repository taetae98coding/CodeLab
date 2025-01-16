package io.github.taetae98coding.codelab.feature.poke.detail

import io.github.taetae98coding.codelab.domain.poke.entity.PokeDetail

internal sealed class PokeDetailUiState {
    data object Loading : PokeDetailUiState()

    data class State(
        val detail: PokeDetail,
    ) : PokeDetailUiState()

    data class Error(
        val retry: () -> Unit,
    ) : PokeDetailUiState()
}
