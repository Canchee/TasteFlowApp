package com.iacanched.tasteflow.domain.usecase

import com.iacanched.tasteflow.data.RecipesRepository
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.domain.model.toDomain
import javax.inject.Inject

class GetRecipeUseCase @Inject constructor(private val repository: RecipesRepository) {
    suspend operator fun invoke(id: Int): Recipe {
        val recipe = repository.getRecipeFromDb(id)
        return recipe.toDomain()
    }
}