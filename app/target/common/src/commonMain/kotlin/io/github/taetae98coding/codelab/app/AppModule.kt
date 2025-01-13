package io.github.taetae98coding.codelab.app

import io.github.taetae98coding.codelab.core.poke.service.PokeHttpClientEngineModule
import io.github.taetae98coding.codelab.core.poke.service.PokeServiceModule
import io.github.taetae98coding.codelab.feature.poke.PokeFeatureModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    includes = [
        PokeServiceModule::class,
        PokeHttpClientEngineModule::class,
        PokeFeatureModule::class,
    ],
)
@ComponentScan
public class AppModule
