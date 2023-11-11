package com.taetae98.codelab.data.local

import app.cash.paging.PagingSource
import com.taetae98.codelab.data.dto.MemoDto

public interface MemoLocalDataSource {
    public suspend fun upsert(memo: MemoDto)
    public suspend fun delete(id: Long)

    public fun page(): PagingSource<Int, MemoDto>
}
