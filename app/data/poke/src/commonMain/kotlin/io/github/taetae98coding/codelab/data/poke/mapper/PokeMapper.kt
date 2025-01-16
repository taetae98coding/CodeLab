package io.github.taetae98coding.codelab.data.poke.mapper

import io.github.taetae98coding.codelab.core.poke.service.entity.PokeDetailEntity
import io.github.taetae98coding.codelab.core.poke.service.entity.PokePageEntity
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import io.github.taetae98coding.codelab.domain.poke.entity.PokeDetail

internal fun PokePageEntity.toPoke(): Poke {
    return Poke(
        id = id,
        name = name,
        thumbnail = thumbnail,
    )
}

internal fun PokeDetailEntity.toDetail(): PokeDetail {
    return PokeDetail(
        name = name,
        thumbnail = thumbnail,
        hp = stats.first { it.stat.name == "hp" }.baseStat,
        attack = stats.first { it.stat.name == "attack" }.baseStat,
        defense = stats.first { it.stat.name == "defense" }.baseStat,
    )
}
