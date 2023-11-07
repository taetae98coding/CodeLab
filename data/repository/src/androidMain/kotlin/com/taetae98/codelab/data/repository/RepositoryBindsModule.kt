package com.taetae98.codelab.data.repository

import com.taetae98.codelab.domain.repository.MemoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
public abstract class RepositoryBindsModule {
    @Binds
    internal abstract fun bindsMemoRepository(repository: MemoRepositoryImpl): MemoRepository
}
