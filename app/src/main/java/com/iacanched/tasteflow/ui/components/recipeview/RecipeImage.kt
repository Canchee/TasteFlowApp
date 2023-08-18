package com.iacanched.tasteflow.ui.components.recipeview

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iacanched.tasteflow.ui.components.CustomAsyncImageForRecipe

@Composable
fun RecipeImage(imageUrl: String?) {
    CustomAsyncImageForRecipe(
        imageUrl = imageUrl,
        modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth()
    )
}