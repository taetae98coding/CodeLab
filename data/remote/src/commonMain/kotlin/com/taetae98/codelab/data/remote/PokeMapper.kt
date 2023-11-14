package com.taetae98.codelab.data.remote

import com.taetae98.codelab.data.dto.PokeDto
import com.taetae98.codelab.data.dto.PokePageDto

internal fun PokeEntity.toDto(): PokeDto {
    return PokeDto(
        id = id,
        name = name,
        image = "",
    )
}

internal fun PokePageEntity.toDto(): PokePageDto {
    return PokePageDto(
        count = count,
        data = data.map(PokeEntity::toDto)
    )
}