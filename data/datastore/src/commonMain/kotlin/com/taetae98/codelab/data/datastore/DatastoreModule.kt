package com.taetae98.codelab.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path

internal class DatastoreModule {
    fun getDatastore(
        produceFile: () -> Path,
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.createWithPath(
            produceFile = produceFile,
        )
    }
}