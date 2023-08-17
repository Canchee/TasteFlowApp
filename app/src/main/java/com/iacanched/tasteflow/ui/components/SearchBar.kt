package com.iacanched.tasteflow.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iacanched.tasteflow.ui.theme.AshGray
import com.iacanched.tasteflow.ui.theme.Mint
import com.iacanched.tasteflow.ui.theme.Orange200
import com.iacanched.tasteflow.ui.theme.Orange500
import com.iacanched.tasteflow.ui.theme.Orange900
import com.iacanched.tasteflow.ui.theme.Russet
import com.iacanched.tasteflow.ui.theme.Saffron

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onSearch(text)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Orange900,
            unfocusedBorderColor = Orange500,
            cursorColor = Orange900

        ),
        shape = RoundedCornerShape(20.dp),
        singleLine = true,
        label = { Text(text = "Search", color = Russet) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Saffron
            )
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            onSearch(text)
            // Hide the keyboard after submitting the search
            keyboardController?.hide()
            //or hide keyboard
            focusManager.clearFocus()
        })
    )
}

@Composable
@Preview
fun SearchbarPreview() {
    SearchBar(onSearch = {})
}