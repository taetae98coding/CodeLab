package com.taetae98.codelab.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.taetae98.codelab.data.preference.DatastorePreference
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest
import org.koin.core.annotation.Factory

@Factory
internal class DatastorePreferenceImpl @KInject constructor(
    @Datastore
    private val dataStore: DataStore<Preferences>
) : DatastorePreference {
    override fun get(): Flow<String> {
        return dataStore.data.mapLatest {
            it[stringPreferencesKey(VALUE)].orEmpty()
        }
    }

    override suspend fun update(value: String) {
        dataStore.edit { it[stringPreferencesKey(VALUE)] = value }
    }

    companion object {
        private const val VALUE = "value"
    }
}
