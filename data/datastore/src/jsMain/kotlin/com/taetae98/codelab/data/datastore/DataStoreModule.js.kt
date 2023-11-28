package com.taetae98.codelab.data.datastore

import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal actual class DataStoreModule {
    @Singleton
    actual fun providesDatastorePreferences(): DatastorePreferences {
        return DatastorePreferences()
    }
}
