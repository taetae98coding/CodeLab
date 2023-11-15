package com.taetae98.codelab.library.lifecycle

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.int

public actual class KSavedStateHandle(
    private val map: MutableMap<String, JsonPrimitive>,
) {
    private val flowMap = mutableMapOf<String, MutableStateFlow<Any?>>()

    @Suppress("UNCHECKED_CAST")
    public actual fun getStateFlow(key: String, initialValue: String): StateFlow<String> {
        return flowMap.getOrPut(key) {
            if (!map.contains(key)) {
                map[key] = JsonPrimitive(initialValue)
            }

            MutableStateFlow(requireNotNull(map[key]?.content))
        }.asStateFlow() as StateFlow<String>
    }

    @Suppress("UNCHECKED_CAST")
    public actual fun getStateFlow(key: String, initialValue: Int): StateFlow<Int> {
        return flowMap.getOrPut(key) {
            if (!map.contains(key)) {
                map[key] = JsonPrimitive(initialValue)
            }

            MutableStateFlow(requireNotNull(map[key]?.int))
        }.asStateFlow() as StateFlow<Int>
    }

    public actual operator fun set(key: String, value: String) {
        map[key] = JsonPrimitive(value)
        flowMap[key]?.value = value
    }
}
