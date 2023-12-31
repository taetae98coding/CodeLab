package com.taetae98.codelab.domain.usecase.core

public abstract class UseCase<P, R> internal constructor() {
    public suspend operator fun invoke(params: P): Result<R> {
        return runCatching { execute(params) }
            .onSuccess { println("${this::class.simpleName}($params) => $it") }
            .onFailure { println("${this::class.simpleName}($params) => $it") }
    }

    protected abstract suspend fun execute(params: P): R
}
