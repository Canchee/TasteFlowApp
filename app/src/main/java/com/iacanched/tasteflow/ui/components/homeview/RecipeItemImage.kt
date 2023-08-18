package com.iacanched.tasteflow.ui.components.homeview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.iacanched.tasteflow.ui.components.CustomAsyncImage

@Composable
fun RecipeItemImage(imageUrl: String?) {
    CustomAsyncImage(
        imageUrl = imageUrl,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .background(Color.White),
    )
}