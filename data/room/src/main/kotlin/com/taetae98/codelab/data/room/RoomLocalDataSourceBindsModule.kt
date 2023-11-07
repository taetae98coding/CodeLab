package com.taetae98.codelab.data.room

import com.taetae98.codelab.data.local.MemoLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
public abstract class RoomLocalDataSourceBindsModule {
    @Binds
    internal abstract fun bindsMemoLocalDataSource(dataSourceImpl: MemoLocalDataSourceImpl): MemoLocalDataSource
}
