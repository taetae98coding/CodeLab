package com.taetae98.codelab.domain.repository

import kotlinx.coroutines.flow.Flow

public interface DatastoreRepository {
    public fun get(): Flow<String>
    public suspend fun update(value: String)
}
