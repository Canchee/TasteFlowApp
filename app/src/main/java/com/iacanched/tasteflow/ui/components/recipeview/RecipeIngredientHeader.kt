package com.iacanched.tasteflow.ui.components.recipeview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iacanched.tasteflow.ui.theme.Russet

@Composable
fun RecipeIngredientsHeader() {
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Ingredients", color = Russet, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(16.dp))
    }
}
