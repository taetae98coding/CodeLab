package io.github.taetae98coding.codelab.app

import io.github.taetae98coding.codelab.data.poke.PokeDataModule
import io.github.taetae98coding.codelab.domain.poke.PokeDomainModule
import org.koin.core.annotation.Module

@Module(
    includes = [
        PokeDataModule::class,
        PokeDomainModule::class,
    ],
)
public class AppPlatformModule
