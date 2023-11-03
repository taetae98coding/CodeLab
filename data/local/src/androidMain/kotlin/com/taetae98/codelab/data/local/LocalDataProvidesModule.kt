package com.taetae98.codelab.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class LocalDataProvidesModule {
    @Provides
    @Singleton
    fun providesMemoDatabase(
        @ApplicationContext
        context: Context,
    ): MemoDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = MemoDatabase::class.java,
            name = "codelab_memo.db",
        ).build()
    }
}
