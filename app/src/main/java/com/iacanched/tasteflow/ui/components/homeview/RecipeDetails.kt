package com.iacanched.tasteflow.ui.components.homeview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EnhancedEncryption
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Restore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iacanched.tasteflow.domain.model.Recipe


@Composable
fun RecipeDetails(recipe: Recipe) {
    Column(modifier = Modifier
        .background(Color.White)
        .padding(5.dp)) {
        RecipeTitle(name = recipe.name)
        Spacer(modifier = Modifier.height(5.dp))
        RecipeInfo(icon = Icons.Filled.Restore, text = recipe.time ?: "", fontSize = 10.sp)
        Spacer(modifier = Modifier.height(5.dp))
        RecipeInfo(icon = Icons.Filled.People, text = recipe.yield.toString(), fontSize = 10.sp)
        Spacer(modifier = Modifier.height(5.dp))
        RecipeInfo(icon = Icons.Filled.EnhancedEncryption, text = "Difficulty: ${recipe.difficulty}", fontSize = 10.sp)
    }
}