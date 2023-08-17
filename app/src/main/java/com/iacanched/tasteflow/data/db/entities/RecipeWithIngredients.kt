package com.iacanched.tasteflow.data.db.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.iacanched.tasteflow.data.db.entities.IngredientEntity
import com.iacanched.tasteflow.data.db.entities.RecipeEntity
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.domain.model.toDomain

data class RecipeWithIngredients(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "recipeId"
    )
    val ingredients: List<IngredientEntity>
)

fun Recipe.toEntity() =
    RecipeWithIngredients(
        recipe = RecipeEntity(
            recipeId = id,
            name = name,
            city = city,
            description = description,
            imageUrl = imageUrl,
            latitude = latitude,
            longitude = longitude,
            yield = yield,
            difficulty = difficulty,
            time = time,
            directions = directions
        ), ingredients = ingredients.map { it.toEntity(id!!) }
    )
