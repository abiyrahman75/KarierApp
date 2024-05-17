package com.example.karier

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.karier.presentation.Login.LoginScreen
import com.example.karier.presentation.Register.RegistrasiScreen

@Composable
fun KarierApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screen.Login.route) {
                LoginScreen(navigateToRegister = {
                    navController.navigate(route = Screen.Register.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                })
            }
            composable(route = Screen.Register.route) {
                RegistrasiScreen(navigateBack = {
                    navController.navigateUp()
                })
            }
        }
//        LoginScreen(modifier = Modifier.padding(paddingValues))
    }
}