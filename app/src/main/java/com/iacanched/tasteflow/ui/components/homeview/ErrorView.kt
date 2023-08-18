package com.iacanched.tasteflow.ui.components.homeview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iacanched.tasteflow.ui.components.ErrorMessage

@Composable
fun ErrorView(modifier: Modifier = Modifier, retryAction: () -> Unit) {
    ErrorMessage(
        modifier = modifier,
        onClick = {
            retryAction()
        }
    )
}