package com.taetae98.codelab.app

import com.taetae98.codelab.data.local.LocalDataSourceModule
import com.taetae98.codelab.data.repository.RepositoryModule
import com.taetae98.codelab.domain.usecase.UseCaseModule
import com.taetae98.codelab.feature.memo.MemoModule
import org.koin.core.annotation.Module

@Module(
    includes = [
        LocalDataSourceModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        MemoModule::class,
    ]
)
public class AppModule