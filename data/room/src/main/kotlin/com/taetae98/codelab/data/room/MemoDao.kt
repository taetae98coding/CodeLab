package com.taetae98.codelab.data.room

import androidx.room.Dao
import androidx.room.Upsert

@Dao
internal interface MemoDao {
    @Upsert
    suspend fun upsert(memo: MemoEntity)
}
