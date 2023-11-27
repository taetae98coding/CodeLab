package com.taetae98.codelab.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okio.Path.Companion.toPath
import javax.inject.Singleton
import kotlin.io.path.Path


@Module
@InstallIn(SingletonComponent::class)
internal class DatastoreProvidesModule {

    @Datastore
    @Provides
    @Singleton
    internal fun providesDatastore(
        @ApplicationContext
        context: Context,
    ): DataStore<Preferences> {
        return DatastoreModule().getDatastore {
            context.filesDir.resolve("datastore.preferences_pb").absolutePath.toPath()
        }
    }
}