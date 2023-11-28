package com.taetae98.codelab.data.datastore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

internal actual class DatastorePreferences {
    actual fun get(): Flow<String> {
        return emptyFlow()
    }

    actual suspend fun update(value: String) = Unit
}
