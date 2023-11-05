package ext

import org.gradle.api.artifacts.dsl.DependencyHandler

public fun DependencyHandler.kspNonAndroidMain(
    dependencyNotation: Any,
) {
    add("kspIosMain", dependencyNotation)
    add("kspJvm", dependencyNotation)
    add("kspJs", dependencyNotation)
}