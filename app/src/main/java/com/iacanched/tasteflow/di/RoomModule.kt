package com.iacanched.tasteflow.di

import android.content.Context
import androidx.room.Room
import com.iacanched.tasteflow.data.db.RecipeDatabase
import com.iacanched.tasteflow.data.db.dao.RecipesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DATABASE_NAME = "recipe_database"

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RecipeDatabase {
        return Room.databaseBuilder(
            context,
            RecipeDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideRecipeDao(database: RecipeDatabase): RecipesDao {
        return database.recipeDao()
    }
}