package com.taetae98.codelab.data.repository

import com.taetae98.codelab.domain.repository.MemoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryBindsModule {
    @Binds
    fun bindsMemoRepository(repository: MemoRepositoryImpl): MemoRepository
}
