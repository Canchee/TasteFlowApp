package com.iacanched.tasteflow.domain.usecase

import com.iacanched.tasteflow.data.RecipesRepository
import com.iacanched.tasteflow.data.network.NetworkResult
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.domain.model.toDomain
import com.iacanched.tasteflow.data.db.entities.toEntity
import javax.inject.Inject

class GetListRecipesUseCase @Inject constructor(private val repository: RecipesRepository) {
    suspend operator fun invoke(): NetworkResult<List<Recipe>> {
        return when(val recipes = repository.getRecipesFromApi()){
            is NetworkResult.Success -> {
                val data = recipes.data
                val dataDomain = data.map { it.toDomain()}
                val dataEntity = dataDomain.map { it.toEntity() }

                repository.clearRecipes()
                repository.insertRecipes(dataEntity)
                NetworkResult.Success(dataDomain)
            }
            is NetworkResult.Error -> {
                NetworkResult.Error(recipes.errorMessage)
            }
            is NetworkResult.Loading -> recipes
            is NetworkResult.Exception -> recipes
        }

    }

}