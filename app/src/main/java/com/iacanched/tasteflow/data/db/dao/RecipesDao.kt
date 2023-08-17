package com.iacanched.tasteflow.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.iacanched.tasteflow.data.db.entities.IngredientEntity
import com.iacanched.tasteflow.data.db.entities.RecipeEntity
import com.iacanched.tasteflow.data.db.entities.RecipeWithIngredients

@Dao
interface RecipesDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredients(ingredients: List<IngredientEntity>)

    @Transaction
    @Query("SELECT * FROM recipes_table")
    suspend fun getAllRecipesWithIngredients(): List<RecipeWithIngredients>

    @Transaction
    @Query("SELECT * FROM recipes_table WHERE recipeId = (:id)")
    suspend fun getRecipeWithIngredients(id: Int): RecipeWithIngredients

    suspend fun insertAll(recipes:List<RecipeWithIngredients>){
        for (recipe in recipes) {
            insertRecipe(recipe.recipe)
            insertIngredients(recipe.ingredients)
        }
    }

    @Transaction
    @Query("DELETE FROM recipes_table")
    suspend fun deleteAllRecipes()

    @Transaction
    @Query("DELETE FROM ingredients_table")
    suspend fun deleteAllIngredients()
}