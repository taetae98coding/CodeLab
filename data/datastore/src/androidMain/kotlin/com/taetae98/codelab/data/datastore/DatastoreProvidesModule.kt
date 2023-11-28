package com.taetae98.codelab.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okio.Path.Companion.toPath

@Module
@InstallIn(SingletonComponent::class)
internal class DatastoreProvidesModule {

    @Datastore
    @Provides
    @Singleton
    internal fun providesDatastore(
        @ApplicationContext
        context: Context
    ): DataStore<Preferences> {
        return DatastoreModule().getDatastore {
            context.filesDir.resolve("datastore.preferences_pb").absolutePath.toPath()
        }
    }
}
