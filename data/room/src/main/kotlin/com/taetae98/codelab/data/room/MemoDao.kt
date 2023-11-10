package com.taetae98.codelab.data.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
internal interface MemoDao {
    @Upsert
    suspend fun upsert(memo: MemoEntity)

    @Query("SELECT * FROM MemoEntity")
    fun page(): PagingSource<Int, MemoEntity>
}
