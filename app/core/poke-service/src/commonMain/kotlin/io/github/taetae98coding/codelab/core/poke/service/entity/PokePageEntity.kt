package io.github.taetae98coding.codelab.core.poke.service.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class PokePageEntity(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String,
) {
    val id: Int = url.substringBeforeLast("/")
        .substringAfterLast("/")
        .toInt()
}
