package com.iacanched.tasteflow.ui.components.mapview

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.iacanched.tasteflow.ui.components.BackIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapTopAppBar(onBackClick: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
            BackIconButton(onBackClick)
        },
        title = {}
    )
}