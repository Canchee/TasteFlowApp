package com.iacanched.tasteflow.ui.components.homeview

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iacanched.tasteflow.ui.theme.Orange500

@Composable
fun RecipeTitle(name: String?) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = name ?: "",
        color = Orange500
    )
}