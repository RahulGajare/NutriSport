package org.rg.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.rg.home.component.BottomBar
import org.rg.home.domain.BottomBarDestination
import org.rg.shared.navigation.Screen

@Composable
fun HomeGraphScreen() {

    val navController = rememberNavController()
    val currentRoute  =  navController.currentBackStackEntryAsState()
    val selectedDestination by remember{
        derivedStateOf {
            val route = currentRoute.value?.destination?.route.toString()
            when{
                route.contains(BottomBarDestination.ProductsOverview.screen.toString()) -> BottomBarDestination.ProductsOverview
                route.contains(BottomBarDestination.Cart.screen.toString()) -> BottomBarDestination.Cart
                route.contains(BottomBarDestination.Categories.screen.toString()) -> BottomBarDestination.Categories
                else -> BottomBarDestination.ProductsOverview
            }
        }
    }


    Scaffold { padding ->
        Column(modifier = Modifier.padding(top = padding.calculateTopPadding(),
            bottom = padding.calculateBottomPadding())
            .fillMaxSize()
        ) {

            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = Screen.ProductsOverview
            ) {
                composable<Screen.ProductsOverview> {
                    ProductsOverviewScreen(
                        navigateToDetails = navigateToDetails
                    )
                }
                composable<Screen.Cart> {
                    CartScreen()
                }
                composable<Screen.Categories> {
                    CategoriesScreen(
                        navigateToCategorySearch = navigateToCategorySearch
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            BottomBar(
                selectedDestination = BottomBarDestination.ProductsOverview,
                onSelect = {
                    //TODO
                }
            )

        }
    }
}