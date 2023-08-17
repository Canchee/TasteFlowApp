package com.iacanched.tasteflow.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.domain.usecase.GetRecipeUseCase
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeViewModelTest {
    private val fakeUseCase: GetRecipeUseCase = mockk(relaxed = true)
    private lateinit var viewModel: RecipeViewModel
    private val fakeStateHandle: SavedStateHandle = mockk(relaxed = true){
        every { get<String>(any()) } returns "2"
    }

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        viewModel = RecipeViewModel(fakeUseCase, fakeStateHandle)
    }

    @After
    fun tearDown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `init should update state as Success`() = runBlocking {
        coEvery { fakeUseCase.invoke(any()) } returns mockedRecipe

        assert(viewModel.state.first() is State.Success)

        coVerify(exactly = 1) { fakeUseCase.invoke(any()) }
    }

    companion object {
        private val mockedRecipe = Recipe(id = 2)
    }
}