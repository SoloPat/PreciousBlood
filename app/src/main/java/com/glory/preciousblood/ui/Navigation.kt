package com.glory.preciousblood.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.glory.preciousblood.ui.screens.Home
import com.glory.preciousblood.ui.screens.AboutUs
import com.glory.preciousblood.ui.screens.NavRoute
import com.glory.preciousblood.ui.screens.PrayerScreen
import com.glory.preciousblood.ui.screens.SettingsScreen



@Composable
fun AppNavigation(navController:NavHostController)  {
    NavHost(navController = navController, startDestination = "home") {
        composable(NavRoute.HOME) {
            Home(navController)
        }
        composable(NavRoute.ABOUT_US) {
            AboutUs()
        }
        composable(NavRoute.SETTINGS) {
            SettingsScreen()
        }
    }
}