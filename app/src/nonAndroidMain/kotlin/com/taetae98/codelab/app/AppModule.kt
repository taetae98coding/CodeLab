package com.taetae98.codelab.app

import com.taetae98.codelab.data.ktor.KtorRemoteDataSourceModule
import com.taetae98.codelab.data.repository.RepositoryModule
import com.taetae98.codelab.data.sqldelight.SqldelightLocalDataSourceModule
import com.taetae98.codelab.domain.usecase.UseCaseModule
import com.taetae98.codelab.feature.datastore.DatastoreModule
import com.taetae98.codelab.feature.memo.MemoModule
import com.taetae98.codelab.feature.poke.PokeModule
import org.koin.core.annotation.Module

@Module(
    includes = [
        RepositoryModule::class,
        UseCaseModule::class,
        SqldelightLocalDataSourceModule::class,
        KtorRemoteDataSourceModule::class,
        MemoModule::class,
        PokeModule::class,
        DatastoreModule::class,
    ]
)
public class AppModule
