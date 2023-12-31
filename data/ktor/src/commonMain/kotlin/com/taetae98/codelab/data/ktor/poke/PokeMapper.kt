package com.taetae98.codelab.data.ktor.poke

import com.taetae98.codelab.data.dto.PokeDetailDto
import com.taetae98.codelab.data.dto.PokeDto
import com.taetae98.codelab.data.dto.PokePageDto

internal fun PokeEntity.toDto(): PokeDto {
    return PokeDto(
        id = id,
        name = name,
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    )
}

internal fun PokePageEntity.toDto(): PokePageDto {
    return PokePageDto(
        count = count,
        data = data.map(PokeEntity::toDto)
    )
}

internal fun PokeDetailEntity.toDto(): PokeDetailDto {
    return PokeDetailDto(
        id = id,
        name = name,
        imageList = imageList()
    )
}
