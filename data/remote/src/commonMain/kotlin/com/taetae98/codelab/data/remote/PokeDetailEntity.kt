package com.taetae98.codelab.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull

@Serializable
internal data class PokeDetailEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("sprites")
    val sprites: JsonObject,
) {
    fun images(): List<String> {
        return sprites.flatMapImage()
    }

    private fun JsonObject.flatMapImage(): List<String> {
        return values.flatMap {
            when (it) {
                is JsonObject -> it.flatMapImage()
                is JsonPrimitive -> listOfNotNull(it.contentOrNull)
                else -> emptyList()
            }
        }
    }
}