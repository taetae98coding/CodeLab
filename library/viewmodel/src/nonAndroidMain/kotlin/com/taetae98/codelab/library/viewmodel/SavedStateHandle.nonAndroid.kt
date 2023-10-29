package com.taetae98.codelab.library.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

public actual class SavedStateHandle(
    public val map: MutableMap<String, String>,
) {
    public val stateFlowMap: MutableMap<String, MutableStateFlow<Any?>> = HashMap()

    @Suppress("UNCHECKED_CAST")
    public actual inline fun <reified T> getStateFlow(key: String, defaultValue: T): StateFlow<T> {
        return stateFlowMap.getOrPut(key) {
            val value = map.getOrPut(key) { Json.encodeToString<T>(defaultValue) }
            MutableStateFlow(Json.decodeFromString<T>(value))
        }.asStateFlow() as StateFlow<T>
    }

    public actual suspend inline fun <reified T> set(key: String, value: T) {
        map[key] = Json.encodeToString<T>(value)
        stateFlowMap.getOrPut(key) { MutableStateFlow(value) }.emit(value)
    }
}