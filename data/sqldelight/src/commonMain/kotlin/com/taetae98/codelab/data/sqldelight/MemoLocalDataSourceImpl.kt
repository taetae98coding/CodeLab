package com.taetae98.codelab.data.sqldelight

import com.taetae98.codelab.core.database.MemoDatabase
import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.data.local.MemoLocalDataSource
import org.koin.core.annotation.Factory

@Factory
internal class MemoLocalDataSourceImpl(
    private val memoDatabase: MemoDatabase,
) : MemoLocalDataSource {
    override suspend fun upsert(memo: MemoDto) {
        memoDatabase.memoEntityQueries.upsert(memo.toEntity())
    }
}
