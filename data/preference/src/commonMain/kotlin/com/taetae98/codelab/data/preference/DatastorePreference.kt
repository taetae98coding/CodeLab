package com.taetae98.codelab.data.preference

import kotlinx.coroutines.flow.Flow

public interface DatastorePreference {
    public fun get(): Flow<String>
    public suspend fun update(value: String)
}