package com.taetae98.codelab.data.repository

import com.taetae98.codelab.data.local.MemoLocalDataSource
import com.taetae98.codelab.domain.entity.Memo
import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.library.inject.KInject
import org.koin.core.annotation.Factory

@Factory
internal class MemoRepositoryImpl @KInject constructor(
    private val memoLocalDataSource: MemoLocalDataSource,
) : MemoRepository {
    override suspend fun upsert(memo: Memo) {
        memoLocalDataSource.upsert(memo.toDto())
    }
}
