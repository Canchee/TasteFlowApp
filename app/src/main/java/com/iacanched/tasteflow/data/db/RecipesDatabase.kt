package com.iacanched.tasteflow.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iacanched.tasteflow.data.db.dao.RecipesDao
import com.iacanched.tasteflow.data.db.entities.IngredientEntity
import com.iacanched.tasteflow.data.db.entities.RecipeEntity

@Database(entities = [RecipeEntity::class, IngredientEntity::class], version = 3, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipesDao
}