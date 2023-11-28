package com.taetae98.codelab.data.datastore

import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
internal expect class DataStoreModule {
    @Singleton
    fun providesDatastorePreferences(): DatastorePreferences
}
