package com.taetae98.codelab.domain.repository

import app.cash.paging.PagingData
import com.taetae98.codelab.domain.entity.Memo
import kotlinx.coroutines.flow.Flow

public interface MemoRepository {
    public suspend fun upsert(memo: Memo)
    public suspend fun delete(id: Long)

    public fun page(): Flow<PagingData<Memo>>
}
