package io.github.taetae98coding.codelab.core.poke.service.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PokePageResponseEntity(
    @SerialName("count")
    val count: Int,
    @SerialName("results")
    val results: List<PokePageEntity>
)
