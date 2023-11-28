package com.taetae98.codelab.data.datastore

import com.taetae98.codelab.data.preference.DatastorePreference
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
internal class DatastorePreferenceImpl @KInject constructor(
    private val preferences: DatastorePreferences
) : DatastorePreference {
    override fun get(): Flow<String> {
        return preferences.get()
    }

    override suspend fun update(value: String) {
        preferences.update(value)
    }
}
