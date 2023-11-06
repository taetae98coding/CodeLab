package com.taetae98.codelab.data.local

import com.taetae98.codelab.core.database.MemoDatabase
import com.taetae98.codelab.data.dto.MemoDto
import org.koin.core.annotation.Factory

@Factory
public actual class MemoLocalDataSource internal constructor(
    private val memoDatabase: MemoDatabase
) {
    public actual suspend fun upsert(memo: MemoDto) {
        memoDatabase.memoEntityQueries.upsert(memo.toEntity())
    }
}
