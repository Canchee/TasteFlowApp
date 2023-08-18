package com.iacanched.tasteflow.ui.components.recipeview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iacanched.tasteflow.domain.model.Recipe

@Composable
fun RecipeContent(recipe: Recipe?) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            RecipeImage(recipe?.imageUrl)
            RecipeIngredientsHeader()
        }

        recipe?.ingredients?.let { ingredients ->
            items(ingredients.size) { index ->
                RecipeIngredientRow(ingredients[index])
            }
        }

        item {
            RecipeDirections(recipe?.directions)
        }
    }
}