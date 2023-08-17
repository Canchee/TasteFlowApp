package com.iacanched.tasteflow.domain.model

import com.iacanched.tasteflow.data.db.entities.RecipeWithIngredients
import com.iacanched.tasteflow.data.model.RecipeModel

data class Recipe(
    var id: Int? = null,
    var name: String? = null,
    var city: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
    var yield: String? = null,
    var difficulty: Int? = null,
    var time: String? = null,
    var ingredients: List<Ingredient> = emptyList(),
    var directions: String? = null
)

fun RecipeModel.toDomain() = Recipe(
    id = id,
    name = name,
    city = city,
    description = description,
    imageUrl = imageUrl,
    latitude = latitude,
    longitude = longitude,
    yield = yield,
    difficulty = difficulty,
    time = time,
    ingredients = ingredients.map { it.toDomain() },
    directions = directions
)

fun RecipeWithIngredients.toDomain() = Recipe(
    id = recipe.recipeId,
    name = recipe.name,
    city = recipe.city,
    description = recipe.description,
    imageUrl = recipe.imageUrl,
    latitude = recipe.latitude,
    longitude = recipe.longitude,
    yield = recipe.yield,
    difficulty = recipe.difficulty,
    time = recipe.time,
    ingredients = ingredients.map { it.toDomain() },
    directions = recipe.directions
)
