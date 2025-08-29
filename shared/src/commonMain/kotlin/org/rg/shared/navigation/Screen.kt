package org.rg.shared.navigation

import kotlinx.serialization.Serializable
@Serializable
sealed class Screen{

    @Serializable
    data object AuthScreen : Screen()
    @Serializable
    data object HomeGraph : Screen()
}