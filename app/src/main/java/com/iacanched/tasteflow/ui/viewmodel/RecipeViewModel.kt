package com.iacanched.tasteflow.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.domain.usecase.GetRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val useCase: GetRecipeUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val argument = checkNotNull(savedStateHandle.get<String>("recipeId")).toInt()
    private val _state = MutableStateFlow<State<Recipe>>(State.Loading)
    val state: StateFlow<State<Recipe>> = _state.asStateFlow()

    init {
        _state.update { State.Loading }
        viewModelScope.launch {
            val response = useCase(id = argument)
            _state.update { State.Success(response) }
        }
    }
}
