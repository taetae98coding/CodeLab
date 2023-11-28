package com.taetae98.codelab.data.ktor

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    includes = [
        JsonModule::class,
        HttpClientEngineModule::class,
        HttpClientModule::class
    ]
)
@ComponentScan
public class KtorRemoteDataSourceModule