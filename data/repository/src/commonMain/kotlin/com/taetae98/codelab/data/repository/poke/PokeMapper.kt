package com.taetae98.codelab.data.repository.poke

import com.taetae98.codelab.data.dto.PokeDetailDto
import com.taetae98.codelab.data.dto.PokeDto
import com.taetae98.codelab.domain.entity.Poke
import com.taetae98.codelab.domain.entity.PokeDetail

internal fun PokeDto.toDomain(): Poke {
    return Poke(
        id = id,
        name = name,
        image = image,
    )
}

internal fun PokeDetailDto.toDomain(): PokeDetail {
    return PokeDetail(
        id = id,
        name = name,
        images = images,
    )
}