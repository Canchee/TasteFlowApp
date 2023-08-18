package com.iacanched.tasteflow.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BackIconButton(onBackClick: () -> Unit){
    IconButton(
        modifier = Modifier,
        onClick = onBackClick
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            tint = Color.White,
            contentDescription = "Back"
        )
    }
}