package com.taetae98.codelab.data.sqldelight

@Module
@ComponentScan
public actual class SqldelightModule {
    @Singleton
    internal actual fun providesMemoDatabase(): MemoDatabase {
        TODO("Not yet implemented")
    }
}