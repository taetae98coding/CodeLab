package io.github.taetae98coding.codelab.core.poke.service.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PokeDetailEntity(
    @SerialName("stats")
    val stats: List<PokeStatEntity>,
)
