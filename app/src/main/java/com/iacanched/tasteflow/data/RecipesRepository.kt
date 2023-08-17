package com.iacanched.tasteflow.data

import com.iacanched.tasteflow.data.db.dao.RecipesDao
import com.iacanched.tasteflow.data.db.entities.RecipeWithIngredients
import com.iacanched.tasteflow.data.model.RecipeModel
import com.iacanched.tasteflow.data.network.NetworkResult
import com.iacanched.tasteflow.data.network.RecipesService
import javax.inject.Inject

class RecipesRepository @Inject constructor(
    private val api: RecipesService,
    private val dao: RecipesDao
) {
    suspend fun getRecipesFromApi(): NetworkResult<List<RecipeModel>> = api.getRecipes()

    suspend fun getRecipesFromDb(): List<RecipeWithIngredients> = dao.getAllRecipesWithIngredients()

    suspend fun getRecipeFromDb(id: Int): RecipeWithIngredients = dao.getRecipeWithIngredients(id)

    suspend fun insertRecipes(recipes: List<RecipeWithIngredients>) = dao.insertAll(recipes)

    suspend fun clearRecipes() {
        dao.deleteAllIngredients()
        dao.deleteAllRecipes()
    }

}
