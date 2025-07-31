package com.vaskorr.testapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vaskorr.testapp.presentation.screen.main.MainScreen
import com.vaskorr.testapp.presentation.screen.purchases.PurchasesScreen
import com.vaskorr.testapp.presentation.screen.register.RegisterScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.MAIN_SCREEN
    ) {
        composable(Routes.MAIN_SCREEN) {
            MainScreen(
                navController = navController
            )
        }

        composable(Routes.REGISTER_SCREEN) {
            RegisterScreen(
                navController = navController
            )
        }

        composable(Routes.PURCHASES_SCREEN) {
            PurchasesScreen(
                navController = navController
            )
        }
    }
}