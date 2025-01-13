package io.github.taetae98coding.codelab.data.poke.mapper

import io.github.taetae98coding.codelab.core.poke.service.entity.PokePageEntity
import io.github.taetae98coding.codelab.domain.poke.entity.Poke

internal fun PokePageEntity.toPoke(): Poke {
    return Poke(
        id = id,
        name = name,
        thumbnail = thumbnail,
    )
}
