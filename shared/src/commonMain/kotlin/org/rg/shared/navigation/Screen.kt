package org.rg.shared.navigation

import kotlinx.serialization.Serializable
@Serializable
sealed class Screen{

    @Serializable
    data object AuthScreen : Screen()
    @Serializable
    data object HomeGraph : Screen()

    @Serializable
    data object ProductsOverview : Screen()

    @Serializable
    data object Cart : Screen()

    @Serializable
    data object Categories : Screen()
}