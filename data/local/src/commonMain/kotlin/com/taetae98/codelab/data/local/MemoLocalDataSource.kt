package com.taetae98.codelab.data.local

import app.cash.paging.PagingData
import com.taetae98.codelab.data.dto.MemoDto
import kotlinx.coroutines.flow.Flow

public interface MemoLocalDataSource {
    public suspend fun upsert(memo: MemoDto)
    public suspend fun delete(id: Long)

    public fun page(): Flow<PagingData<MemoDto>>
}
