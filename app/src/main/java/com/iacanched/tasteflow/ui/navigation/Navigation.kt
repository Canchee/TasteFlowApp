package com.iacanched.tasteflow.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iacanched.tasteflow.ui.view.HomeView
import com.iacanched.tasteflow.ui.view.MapView
import com.iacanched.tasteflow.ui.view.RecipeView

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeView(navController = navController)
        }
        composable(route = "recipe/{recipeId}"){
            val uId = it.arguments?.getString("recipeId")
            uId?.let {
                RecipeView(navController = navController)
            }
        }
        composable(route = "map/{recipeId}",
            ) {
           val uId = it.arguments?.getString("recipeId")
            uId?.let {
                MapView(navController = navController)
            }

        }
    }
}

