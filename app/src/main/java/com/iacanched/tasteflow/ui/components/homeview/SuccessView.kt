package com.iacanched.tasteflow.ui.components.homeview

import androidx.compose.runtime.Composable
import com.iacanched.tasteflow.domain.model.Recipe

@Composable
fun SuccessView(recipes: List<Recipe>, onClick: (String) -> Unit) {
    RecipesList(
        recipes = recipes,
        onRecipeClick = { recipeId ->
            onClick("recipe/$recipeId")
        }
    )
}