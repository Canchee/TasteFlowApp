package com.iacanched.tasteflow.data.network

import com.iacanched.tasteflow.data.model.RecipeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class RecipesService @Inject constructor(private val api: RecipesAPI) {
    suspend fun getRecipes(): NetworkResult<List<RecipeModel>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getRecipes()
                val body = response.body()
                if (response.isSuccessful) {
                    if (body != null) {
                        NetworkResult.Success(body)
                    } else {
                        NetworkResult.Error("Something went wrong")
                    }
                } else {
                    NetworkResult.Error("Something went wrong")
                }
            } catch (e: HttpException) {
                NetworkResult.Error("Something went wrong")
            } catch (e: Throwable) {
                NetworkResult.Exception(e)
            }
        }
    }
}