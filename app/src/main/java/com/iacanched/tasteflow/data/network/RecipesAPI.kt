package com.iacanched.tasteflow.data.network

import com.iacanched.tasteflow.data.model.RecipeModel
import retrofit2.Response
import retrofit2.http.GET

interface RecipesAPI {
    @GET("v1/recipes")
    suspend fun getRecipes(): Response<List<RecipeModel>>
}