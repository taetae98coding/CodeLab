package com.taetae98.codelab.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MemoEntity::class],
    version = 1,
)
internal abstract class MemoDatabase : RoomDatabase() {
    abstract fun memo(): MemoDao
}
