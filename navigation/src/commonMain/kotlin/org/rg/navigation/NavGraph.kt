package org.rg.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.rg.auth.AuthScreen
import org.rg.home.HomeGraphScreen
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
            AuthScreen(){
                navController.navigate(Screen.HomeGraph){
                    popUpTo<Screen.AuthScreen> { inclusive = true }
                }
            }

            composable<Screen.HomeGraph> {
                HomeGraphScreen()
            }
        }

    }
}