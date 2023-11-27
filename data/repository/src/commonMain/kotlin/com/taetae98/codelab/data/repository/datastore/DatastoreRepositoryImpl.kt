package com.taetae98.codelab.data.repository.datastore

import com.taetae98.codelab.data.preference.DatastorePreference
import com.taetae98.codelab.domain.repository.DatastoreRepository
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
internal class DatastoreRepositoryImpl @KInject constructor(
    private val datastorePreference: DatastorePreference
) : DatastoreRepository {
    override fun get(): Flow<String> {
        return datastorePreference.get()
    }

    override suspend fun update(value: String) {
        datastorePreference.update(value)
    }
}
