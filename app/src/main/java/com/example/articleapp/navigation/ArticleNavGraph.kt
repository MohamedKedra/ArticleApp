package com.example.articleapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.articleapp.feature.details.DetailsScreen
import com.example.articleapp.feature.home.HomeScreen
import com.example.articleapp.feature.home.HomeViewModel

@Composable
fun ArticleNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToDetails = {
                    navController.navigate("details")
                }
            )
        }
        composable("details") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("home")
            }
            val homeViewModel: HomeViewModel = hiltViewModel(parentEntry)

            DetailsScreen(
                onBackClicked = {
                    navController.popBackStack()
                },
                viewModel = homeViewModel
            )
        }
    }
}