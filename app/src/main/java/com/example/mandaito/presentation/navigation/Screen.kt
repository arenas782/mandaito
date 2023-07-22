package com.example.mandaito.presentation.navigation

const val HOME_ROUTE = "home_route"

sealed class Screen(val route: String, val baseRoute: String = "") {
    object HomeScreen : Screen("home_screen")
}