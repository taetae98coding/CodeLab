package com.taetae98.codelab.data.local

import com.taetae98.codelab.data.local.sqldelight.SqldelightModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    includes = [SqldelightModule::class]
)
@ComponentScan
public class LocalDataSourceModule
