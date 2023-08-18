package com.iacanched.tasteflow.ui.components.homeview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iacanched.tasteflow.R
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.ui.theme.Russet

@Composable
fun RecipesList(recipes: List<Recipe>, onRecipeClick: (Int) -> Unit) {
    Column(modifier = Modifier.padding(top = 10.dp)) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = stringResource(R.string.recipes),
            color = Russet,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(recipes.size) {
                RecipeItem(recipe = recipes[it], onClick = onRecipeClick)
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun RecipesListPreview() {
    val recipes: List<Recipe> = listOf(
    )
    RecipesList(recipes = recipes, onRecipeClick = {})
}