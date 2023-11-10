package com.taetae98.codelab.data.sqldelight

import com.taetae98.codelab.core.database.MemoEntity
import com.taetae98.codelab.data.dto.MemoDto

internal fun MemoDto.toEntity(): MemoEntity {
    return MemoEntity(
        id = -1,
        title = title,
    )
}

internal fun MemoEntity.toDto(): MemoDto {
    return MemoDto(
        id = id,
        title = title,
    )
}
