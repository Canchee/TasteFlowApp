package com.iacanched.tasteflow.ui.components.mapview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.ui.theme.Orange500

@Composable
fun MapInfoCard(modifier: Modifier = Modifier, recipe: Recipe) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f),
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = recipe.city ?: "",
                color = Orange500,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(content = { item { Text(text = recipe.description ?: "") } })
        }
    }
}