package com.iacanched.tasteflow.ui.components.recipeview

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iacanched.tasteflow.ui.components.BackIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeTopAppBar(recipeName: String?, onBackClick: () -> Unit, onLocationIconClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
            BackIconButton (onBackClick)
        },
        title = {
            recipeName?.let {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = it,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier,
                onClick = onLocationIconClick
            ) {
                Icon(
                    imageVector = Icons.Rounded.LocationOn,
                    tint = Color.White,
                    contentDescription = "Location"
                )
            }
        }
    )
}