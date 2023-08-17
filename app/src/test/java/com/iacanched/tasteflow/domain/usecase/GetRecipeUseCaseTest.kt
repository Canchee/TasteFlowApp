package com.iacanched.tasteflow.domain.usecase

import com.iacanched.tasteflow.data.RecipesRepository
import com.iacanched.tasteflow.data.db.entities.RecipeEntity
import com.iacanched.tasteflow.data.db.entities.RecipeWithIngredients
import com.iacanched.tasteflow.domain.model.Recipe
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetRecipeUseCaseTest {

    private val repository: RecipesRepository = mockk()
    private val useCase = GetRecipeUseCase(repository)

    @Before
    fun setUp() {
        coEvery { repository.getRecipeFromDb(any()) } returns mockedRecipeWithIngredients
    }

    @After
    fun tearDown() {
        clearMocks(repository)
    }

    @Test
    fun `invoke() should return correct domain recipe`() = runBlocking {
        val expectedDomainRecipe = mockedDomainRecipe

        val result = useCase.invoke(2)

        coVerify(exactly = 1) { repository.getRecipeFromDb(2) }
        assert(result == expectedDomainRecipe)
    }

    companion object {
        // Mocked data for testing
        private val mockedRecipeWithIngredients =
            RecipeWithIngredients(recipe = RecipeEntity(recipeId = 2), ingredients = listOf())
        private val mockedDomainRecipe = Recipe(id = 2, ingredients = listOf())
    }
}