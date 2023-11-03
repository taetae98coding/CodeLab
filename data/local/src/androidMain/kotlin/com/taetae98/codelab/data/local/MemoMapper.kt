package com.taetae98.codelab.data.local

import com.taetae98.codelab.data.dto.MemoDto

internal fun MemoDto.toEntity(): MemoEntity {
    return MemoEntity(
        id = id,
        title = title,
    )
}
