package com.taetae98.codelab.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import org.koin.core.annotation.Factory

@Factory
internal actual class DatastorePreferences @KInject constructor(
    @Datastore
    private val dataStore: DataStore<Preferences>
) {
    actual fun get(): Flow<String> {
        return dataStore.data.mapLatest {
            it[stringPreferencesKey(VALUE)].orEmpty()
        }
    }

    actual suspend fun update(value: String) {
        dataStore.edit { it[stringPreferencesKey(VALUE)] = value }
    }

    companion object {
        private const val VALUE = "value"
    }
}
