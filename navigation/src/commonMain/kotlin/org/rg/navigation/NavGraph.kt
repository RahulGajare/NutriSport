package org.rg.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.rg.auth.AuthScreen
import org.rg.shared.navigation.Screen

@Composable
fun SetupNavGraph(startDestination : Screen =  Screen.AuthScreen){

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    )
    {
        composable<Screen.AuthScreen>{
            AuthScreen()
        }
    }
}