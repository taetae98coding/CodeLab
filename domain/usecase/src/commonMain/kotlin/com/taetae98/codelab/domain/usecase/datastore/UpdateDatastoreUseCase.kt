package com.taetae98.codelab.domain.usecase.datastore

import com.taetae98.codelab.domain.repository.DatastoreRepository
import com.taetae98.codelab.domain.usecase.core.UseCase
import com.taetae98.codelab.library.inject.KInject
import org.koin.core.annotation.Factory

@Factory
public class UpdateDatastoreUseCase @KInject internal constructor(
    private val datastoreRepository: DatastoreRepository
) : UseCase<String, Unit>() {
    override suspend fun execute(params: String) {
        datastoreRepository.update(params)
    }
}
