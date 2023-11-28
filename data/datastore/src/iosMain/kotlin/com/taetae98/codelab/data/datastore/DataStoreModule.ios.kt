package com.taetae98.codelab.data.datastore

import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@Module
internal actual class DataStoreModule {
    @OptIn(ExperimentalForeignApi::class)
    @Singleton
    actual fun providesDatastorePreferences(): DatastorePreferences {
        val dataStore = DatastoreManager().getDatastore {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null
            )

            "${documentDirectory?.path}/datastore.preferences_pb".toPath()
        }

        return DatastorePreferences(dataStore)
    }
}
