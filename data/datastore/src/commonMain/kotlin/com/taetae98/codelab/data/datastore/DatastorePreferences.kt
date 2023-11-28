package com.taetae98.codelab.data.datastore

import kotlinx.coroutines.flow.Flow

internal expect class DatastorePreferences {
    fun get(): Flow<String>
    suspend fun update(value: String)
}
