package com.taetae98.codelab.feature.poke

import androidx.lifecycle.SavedStateHandle
import com.taetae98.codelab.domain.usecase.poke.GetPokeDetailUseCase
import com.taetae98.codelab.domain.usecase.poke.PagePokeUseCase
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class PokePageViewModelImpl @Inject constructor(
    savedStateHandle: SavedStateHandle,
    pagePokeUseCase: PagePokeUseCase,
    getPokeDetailUseCase: GetPokeDetailUseCase
) : PokePageViewModel(
    kSavedStateHandle = KSavedStateHandle(savedStateHandle),
    pagePokeUseCase = pagePokeUseCase,
    getPokeDetailUseCase = getPokeDetailUseCase
)
