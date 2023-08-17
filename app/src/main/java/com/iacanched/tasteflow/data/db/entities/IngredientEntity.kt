package com.iacanched.tasteflow.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iacanched.tasteflow.domain.model.Ingredient

@Entity(tableName = "ingredients_table")
data class IngredientEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ingredientId") val ingredient: Int = 0,
    @ColumnInfo(name = "recipeId") val recipeId: Int,  // Foreign key reference to RecipeEntity
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "amount") val amount: String?
)

fun Ingredient.toEntity(recipeId: Int) =
    IngredientEntity(recipeId = recipeId, name = name, amount = amount)