package com.iacanched.tasteflow.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iacanched.tasteflow.R
import com.iacanched.tasteflow.ui.theme.Pacifico

@Composable
fun AppName() {
    Text(
        modifier = Modifier.padding(10.dp),
        text = stringResource(id = R.string.app_name),
        fontFamily = Pacifico,
        fontSize = 30.sp
    )
}

@Composable
@Preview(showBackground = true)
fun AppNamePreview() {
    AppName()
}