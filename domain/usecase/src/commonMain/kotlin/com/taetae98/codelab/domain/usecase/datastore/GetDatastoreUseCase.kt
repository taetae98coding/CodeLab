package com.taetae98.codelab.domain.usecase.datastore

import com.taetae98.codelab.domain.repository.DatastoreRepository
import com.taetae98.codelab.domain.usecase.core.FlowUseCase
import com.taetae98.codelab.library.inject.KInject
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
public class GetDatastoreUseCase @KInject internal constructor(
    private val datastoreRepository: DatastoreRepository,
) : FlowUseCase<Unit, String>() {
    override fun execute(params: Unit): Flow<String> {
        return datastoreRepository.get()
    }
}