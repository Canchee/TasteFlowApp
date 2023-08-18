package com.iacanched.tasteflow.ui.components.homeview

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iacanched.tasteflow.ui.theme.Orange900

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
        color = Orange900
    )
}