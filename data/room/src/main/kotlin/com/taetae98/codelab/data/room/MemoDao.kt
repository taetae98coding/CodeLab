package com.taetae98.codelab.data.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.taetae98.codelab.data.dto.MemoDto

@Dao
internal interface MemoDao {
    @Upsert
    suspend fun upsert(memo: MemoEntity)

    @Query("DELETE FROM MemoEntity WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("SELECT * FROM MemoEntity")
    fun page(): PagingSource<Int, MemoDto>
}
