package com.iacanched.tasteflow.domain.usecase

import com.google.common.truth.Truth
import com.iacanched.tasteflow.data.RecipesRepository
import com.iacanched.tasteflow.data.model.RecipeModel
import com.iacanched.tasteflow.data.network.NetworkResult
import com.iacanched.tasteflow.domain.model.Recipe
import io.mockk.Runs
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.runBlocking

import org.junit.After
import org.junit.Before
import org.junit.Test

class GetListRecipesUseCaseTest {

    private val repository: RecipesRepository = mockk()
    private val useCase = GetListRecipesUseCase(repository)

    @Before
    fun setUp() {
        coEvery { repository.clearRecipes() } just Runs
        coEvery { repository.insertRecipes(any()) } just Runs
    }

    @After
    fun tearDown() {
        clearMocks(repository)
    }

    @Test
    fun `invoke() returns Success with transformed data`() = runBlocking {
        coEvery { repository.getRecipesFromApi() } returns NetworkResult.Success(mockedRecipeData)
        val expectedResult = NetworkResult.Success(mockedDomainData)

        val result = useCase.invoke()

        coVerify(exactly = 1) { repository.getRecipesFromApi() }
        coVerify(exactly = 1) { repository.clearRecipes() }
        coVerify(exactly = 1) { repository.insertRecipes(any()) }
        assert(result == expectedResult)
    }

    @Test
    fun `invoke() returns Error`() = runBlocking {
        coEvery { repository.getRecipesFromApi() } returns NetworkResult.Error(mockedErrorMessage)
        val expectedResult = NetworkResult.Error(mockedErrorMessage)

        val result = useCase.invoke()

        coVerify(exactly = 1) { repository.getRecipesFromApi() }
        coVerify(exactly = 0) { repository.clearRecipes() }
        coVerify(exactly = 0) { repository.insertRecipes(any()) }
        assert(result == expectedResult)
    }

    @Test
    fun `invoke() returns Loading`() = runBlocking {
        coEvery { repository.getRecipesFromApi() } returns NetworkResult.Loading
        val expectedResult = NetworkResult.Loading

        val result = useCase.invoke()

        coVerify(exactly = 1) { repository.getRecipesFromApi() }
        coVerify(exactly = 0) { repository.clearRecipes() }
        coVerify(exactly = 0) { repository.insertRecipes(any()) }
        assert(result == expectedResult)
    }

    @Test
    fun `invoke() returns Exception`() = runBlocking {
        coEvery { repository.getRecipesFromApi() } returns NetworkResult.Exception(mockedThrowable)
        val expectedResult = NetworkResult.Exception(mockedThrowable)

        val result = useCase.invoke()

        coVerify(exactly = 1) { repository.getRecipesFromApi() }
        coVerify(exactly = 0) { repository.clearRecipes() }
        coVerify(exactly = 0) { repository.insertRecipes(any()) }
        Truth.assertThat(result).isInstanceOf(expectedResult::class.java)
    }

    companion object {
        private val mockedRecipeData = listOf(RecipeModel(id = 2))
        private val mockedDomainData = listOf(Recipe(id = 2))
        private const val mockedErrorMessage = "Error message"
        private val mockedThrowable: Throwable =  mockk(relaxed = true)
    }
}