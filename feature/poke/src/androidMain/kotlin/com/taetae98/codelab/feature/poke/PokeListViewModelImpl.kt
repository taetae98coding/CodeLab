package com.taetae98.codelab.feature.poke

import com.taetae98.codelab.domain.usecase.poke.PagePokeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class PokeListViewModelImpl @Inject constructor(
    private val pagePokeUseCase: PagePokeUseCase,
) : PokeListViewModel(pagePokeUseCase = pagePokeUseCase)
