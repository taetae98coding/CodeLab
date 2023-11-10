package com.taetae98.codelab.domain.usecase.memo

import app.cash.paging.PagingData
import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.domain.usecase.core.FlowUseCase
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
public class PageMemoUseCase @KInject internal constructor(
    private val memoRepository: MemoRepository,
) : FlowUseCase<Unit, PagingData<Memo>>() {
    override fun execute(params: Unit): Flow<PagingData<Memo>> {
        return memoRepository.page()
    }
}
