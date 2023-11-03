package com.taetae98.codelab.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class MemoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
)
