package com.taetae98.codelab.data.datastore

import com.taetae98.codelab.data.preference.DatastorePreference
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DatastoreBindsModule {
    @Binds
    abstract fun bindsDatastorePreference(datastorePreference: DatastorePreferenceImpl): DatastorePreference
}
