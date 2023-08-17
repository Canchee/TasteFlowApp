package com.iacanched.tasteflow.ui.viewmodel

import com.google.common.truth.Truth
import com.iacanched.tasteflow.data.network.NetworkResult
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.domain.usecase.GetListRecipesUseCase
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val fakeUseCase: GetListRecipesUseCase = mockk(relaxed = true)
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        viewModel = HomeViewModel(fakeUseCase)
    }

    @After
    fun tearDown() {
        clearMocks(fakeUseCase)
        Dispatchers.resetMain()
    }

    @Test
    fun `loadRecipes() should update state as Success`() = runBlocking {
        coEvery { fakeUseCase.invoke() } returns NetworkResult.Success(mockedRecipeList)
        viewModel.loadRecipes()

        assert(viewModel.state.first() is State.Success)

        coVerify(exactly = 2) { viewModel.loadRecipes() }
        coVerify(exactly = 2) { fakeUseCase.invoke() }
    }

    @Test
    fun `loadRecipes() should update state as Loading`() = runBlocking {
        coEvery { fakeUseCase.invoke() } returns NetworkResult.Loading
        viewModel.loadRecipes()

        assert(viewModel.state.first() is State.Loading)

        coVerify(exactly = 2) { viewModel.loadRecipes() }
        coVerify(exactly = 2) { fakeUseCase.invoke() }
    }

    @Test
    fun `loadRecipes() should update state as Error`() = runBlocking {
        coEvery { fakeUseCase.invoke() } returns NetworkResult.Error(errorMessage = mockedErrorMessage)
        viewModel.loadRecipes()

        assert(viewModel.state.first() is State.Error)

        coVerify(exactly = 2) { viewModel.loadRecipes() }
        coVerify(exactly = 2) { fakeUseCase.invoke() }
    }

    @Test
    fun `filterItems() updates filteredList`() = runBlocking {
        coEvery { fakeUseCase.invoke() } returns NetworkResult.Success(mockedRecipeList)
        viewModel.loadRecipes()
        viewModel.searchAction(mockedSearchString)

        Truth.assertThat(viewModel.filteredList.first() ).isEqualTo(mockedRecipeList)
    }

    @Test
    fun `filterItems() return empty filteredList`() = runBlocking {
        coEvery { fakeUseCase.invoke() } returns NetworkResult.Error(mockedErrorMessage)
        viewModel.loadRecipes()
        viewModel.searchAction(mockedSearchString)

        Truth.assertThat(viewModel.filteredList.first() ).isEmpty()
    }

    companion object {
        private const val mockedSearchString = "recipe"
        private val mockedRecipeList = listOf(Recipe(id = 2, name = mockedSearchString))
        private const val mockedErrorMessage = "Error message"
    }
}