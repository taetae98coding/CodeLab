package io.github.taetae98coding.codelab.app

import io.github.taetae98coding.codelab.feature.poke.PokeFeatureModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    includes = [
        PokeFeatureModule::class,
    ]
)
@ComponentScan
public class AppModule
