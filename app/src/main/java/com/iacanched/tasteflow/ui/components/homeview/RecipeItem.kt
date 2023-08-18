package com.iacanched.tasteflow.ui.components.homeview

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iacanched.tasteflow.domain.model.Ingredient
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.ui.theme.Orange200

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeItem(recipe: Recipe, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(end = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Orange200),
        onClick = { onClick(recipe.id!!) }
    ) {
        Row {
            RecipeItemImage(imageUrl = recipe.imageUrl)
            RecipeDetails(recipe = recipe)
        }
    }
}


@Composable
@Preview(showBackground = true)
fun RecipeItemPreview() {
    val mockRecipe = Recipe(
        id = 1,
        name = "Pizza",
        description = "From Italy",
        imageUrl = "https://images.pexels.com/photos/2147491/pexels-photo-2147491.jpeg",
        latitude = 40.853294,
        longitude = 14.305573,
        yield = "4-6 people",
        difficulty = 4,
        time = "2 hours",
        ingredients = listOf(Ingredient("Tomato", "3 pieces")),
        directions = "Prepare it"
    )

    RecipeItem(mockRecipe) {}
}