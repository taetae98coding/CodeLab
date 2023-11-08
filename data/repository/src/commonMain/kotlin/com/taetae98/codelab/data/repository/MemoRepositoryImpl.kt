package com.taetae98.codelab.data.repository

import app.cash.paging.PagingData
import app.cash.paging.map
import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.data.local.MemoLocalDataSource
import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Factory

@Factory
internal class MemoRepositoryImpl @KInject constructor(
    private val memoLocalDataSource: MemoLocalDataSource,
) : MemoRepository {
    override suspend fun upsert(memo: Memo) {
        memoLocalDataSource.upsert(memo.toDto())
    }

    override fun page(): Flow<PagingData<Memo>> {
        return memoLocalDataSource.page()
            .map { it.map(MemoDto::toDomain) }
    }
}
