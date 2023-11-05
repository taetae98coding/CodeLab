package ext

import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun DependencyHandler.implementation(
    dependencyNotation: Any,
) {
    add("implementation", dependencyNotation)
}

internal fun DependencyHandler.ksp(
    dependencyNotation: Any,
) {
    add("ksp", dependencyNotation)
}

internal fun DependencyHandler.kspAndroidMain(
    dependencyNotation: Any,
) {
    add("kspAndroid", dependencyNotation)
}

public fun DependencyHandler.kspNonAndroidMain(
    dependencyNotation: Any,
) {
    add("kspIosMain", dependencyNotation)
    add("kspJvm", dependencyNotation)
    add("kspJs", dependencyNotation)
}