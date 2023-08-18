package com.iacanched.tasteflow.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.iacanched.tasteflow.ui.components.recipeview.RecipeContent
import com.iacanched.tasteflow.ui.components.recipeview.RecipeTopAppBar
import com.iacanched.tasteflow.ui.viewmodel.RecipeViewModel

@OptIn(ExperimentalTextApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RecipeView(viewModel: RecipeViewModel = hiltViewModel(), navController: NavController) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val recipe = state.extractRecipe()

    Scaffold(
        topBar = {
            RecipeTopAppBar(recipe?.name, onBackClick = {
                navController.popBackStack()
            }) {
                navController.navigate("map/${recipe?.id}")
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            RecipeContent(recipe)
        }
    }
}
