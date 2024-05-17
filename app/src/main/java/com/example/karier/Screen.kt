package com.example.karier

sealed class Screen(val route: String) {
    data object Register : Screen("register")
    data object Login : Screen("login")
    data object Dashboard: Screen("Dashboard")
}