package com.taetae98.codelab.app

import com.taetae98.codelab.data.repository.RepositoryModule
import com.taetae98.codelab.data.sqldelight.SqldelightLocalDataSourceModule
import com.taetae98.codelab.domain.usecase.UseCaseModule
import com.taetae98.codelab.feature.memo.MemoModule
import org.koin.core.annotation.Module

@Module(
    includes = [
        RepositoryModule::class,
        UseCaseModule::class,
        MemoModule::class,
        SqldelightLocalDataSourceModule::class,
    ],
)
public class AppModule
