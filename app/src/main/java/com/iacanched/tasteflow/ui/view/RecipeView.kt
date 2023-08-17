package com.iacanched.tasteflow.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.RestaurantMenu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.ui.components.CustomAsyncImage
import com.iacanched.tasteflow.ui.components.CustomAsyncImageForRecipe
import com.iacanched.tasteflow.ui.theme.Orange900
import com.iacanched.tasteflow.ui.theme.Russet
import com.iacanched.tasteflow.ui.viewmodel.RecipeViewModel
import com.iacanched.tasteflow.ui.viewmodel.State

@OptIn(ExperimentalTextApi::class, ExperimentalMaterial3Api::class)
@Composable
fun RecipeView(viewModel: RecipeViewModel = hiltViewModel(), navController: NavController) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val recipe = when (val currentState = state) {
        is State.Error -> {
            // Handle the error state
            TODO() // Replace with your error handling logic
        }

        is State.Loading -> {
            // Handle the loading state if needed
            null // Early return, as there's nothing to display during loading
        }

        is State.Success -> currentState.data
    }


    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                navigationIcon = {
                    IconButton(modifier = Modifier,
                        onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            tint = Color.White,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    recipe?.name?.let {
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
                    IconButton(modifier = Modifier,
                        onClick = { navController.navigate("map/${recipe?.id}") }) {
                        Icon(
                            imageVector = Icons.Rounded.LocationOn,
                            tint = Color.White,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {

                    CustomAsyncImageForRecipe(
                        imageUrl = recipe?.imageUrl,
                        modifier = Modifier
                            .fillMaxHeight(0.2f)
                            .fillMaxWidth()
                    )
                    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Ingredients", color = Russet, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

                if (recipe != null) {
                    items(recipe.ingredients.size) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.RestaurantMenu,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = recipe.ingredients[it].amount.toString() + " - " + recipe.ingredients[it].name.toString())
                        }
                    }
                }

                item {
                    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "How to make", color = Russet, fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        recipe?.directions?.let { Text(text = it) }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecipeViewPreview() {
    //RecipeView()
}