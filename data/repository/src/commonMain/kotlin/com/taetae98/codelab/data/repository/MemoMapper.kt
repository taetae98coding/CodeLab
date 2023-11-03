package com.taetae98.codelab.data.repository

import com.taetae98.codelab.data.dto.MemoDto
import com.taetae98.codelab.domain.entity.Memo

internal fun Memo.toDto(): MemoDto {
    return MemoDto(
        id = id,
        title = title,
    )
}
