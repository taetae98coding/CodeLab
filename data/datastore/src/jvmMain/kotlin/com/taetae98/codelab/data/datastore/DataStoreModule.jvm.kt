package com.taetae98.codelab.data.datastore

import okio.Path.Companion.toPath
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal actual class DataStoreModule {
    @Singleton
    actual fun providesDatastorePreferences(): DatastorePreferences {
        val dataStore = DatastoreManager().getDatastore {
            "datastore.preferences_pb".toPath()
        }

        return DatastorePreferences(dataStore)
    }
}
