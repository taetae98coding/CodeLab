package com.taetae98.codelab.data.room

import com.taetae98.codelab.data.dto.MemoDto

internal fun MemoDto.toEntity(): MemoEntity {
    return MemoEntity(
        id = id,
        title = title
    )
}

internal fun MemoEntity.toDto(): MemoDto {
    return MemoDto(
        id = id,
        title = title
    )
}
