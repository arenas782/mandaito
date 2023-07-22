package com.example.mandaito.presentation.navigation.navgraph

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.mandaito.presentation.navigation.HOME_ROUTE


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE
    ) {
        loginNavGraph(navController = navController)
    }
}
