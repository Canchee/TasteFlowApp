package com.iacanched.tasteflow.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.EnhancedEncryption
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iacanched.tasteflow.domain.model.Ingredient
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.ui.theme.Orange200
import com.iacanched.tasteflow.ui.theme.Orange500
import com.iacanched.tasteflow.ui.theme.Orange600
import com.iacanched.tasteflow.ui.theme.Orange900

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeItem(recipe: Recipe, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(end = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Orange200),
        onClick = { onClick(recipe.id!!) }
    ) {
        Row {
            CustomAsyncImage(
                imageUrl = recipe.imageUrl,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .background(Color.White),
            )
            Column(modifier = Modifier
                .background(Color.White)
                .padding(5.dp)) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = recipe.name ?: "",
                    color = Orange500
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Icon( Icons.Filled.Restore, contentDescription = null, modifier = Modifier.size(14.dp) )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = recipe.time ?: "",
                        fontSize = 10.sp
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Icon( Icons.Filled.People, contentDescription = null, modifier = Modifier.size(14.dp) )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text =  recipe.yield.toString() ?: "",
                        fontSize = 10.sp
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Icon( Icons.Filled.EnhancedEncryption, contentDescription = null, modifier = Modifier.size(14.dp) )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Difficulty: " + recipe.difficulty.toString() ?: "",
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun RecipeItemPreview() {
    val mockRecipe: Recipe = Recipe(
        id = 1,
        name = "Pizza",
        description = "From Italy",
        imageUrl = "https://images.pexels.com/photos/2147491/pexels-photo-2147491.jpeg",
        latitude = 40.853294,
        longitude = 14.305573,
        yield = "4-6 people",
        difficulty = 4,
        time = "2 hours",
        ingredients = listOf(Ingredient("Tomato", "3 pieces")),
        directions = "Prepare it"
    )

    RecipeItem(mockRecipe) {}
}