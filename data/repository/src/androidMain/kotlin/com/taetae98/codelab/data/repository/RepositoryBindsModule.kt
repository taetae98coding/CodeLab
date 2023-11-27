package com.taetae98.codelab.data.repository

import com.taetae98.codelab.data.repository.datastore.DatastoreRepositoryImpl
import com.taetae98.codelab.data.repository.memo.MemoRepositoryImpl
import com.taetae98.codelab.data.repository.poke.PokeRepositoryImpl
import com.taetae98.codelab.domain.repository.DatastoreRepository
import com.taetae98.codelab.domain.repository.MemoRepository
import com.taetae98.codelab.domain.repository.PokeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
public abstract class RepositoryBindsModule {
    @Binds
    internal abstract fun bindsMemoRepository(repository: MemoRepositoryImpl): MemoRepository

    @Binds
    internal abstract fun bindsPokeRepository(repository: PokeRepositoryImpl): PokeRepository

    @Binds
    internal abstract fun bindsDatastoreRepository(repository: DatastoreRepositoryImpl): DatastoreRepository
}
