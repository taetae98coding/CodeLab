package com.taetae98.codelab.data.repository.poke

import com.taetae98.codelab.data.dto.PokeDto
import com.taetae98.codelab.domain.entity.Poke

internal fun PokeDto.toDomain(): Poke {
    return Poke(
        id = id,
        name = name,
        image = image,
    )
}
