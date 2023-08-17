package com.iacanched.tasteflow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iacanched.tasteflow.data.network.NetworkResult
import com.iacanched.tasteflow.domain.model.Recipe
import com.iacanched.tasteflow.domain.usecase.GetListRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: GetListRecipesUseCase): ViewModel() {

    private val _state = MutableStateFlow<State<List<Recipe>>>(State.Loading)
    val state: StateFlow<State<List<Recipe>>> = _state.asStateFlow()

    private val _filteredList = MutableStateFlow<List<Recipe>>(emptyList())
    val filteredList: StateFlow<List<Recipe>> = _filteredList.asStateFlow()

    init {
        loadRecipes()
    }

    fun loadRecipes() {
        _state.update { State.Loading }
        viewModelScope.launch {
            when(val response =  useCase()){
                is NetworkResult.Success -> {
                    _state.update { State.Success(response.data) }
                    _filteredList.update { response.data }
                }
                is NetworkResult.Loading -> {
                    _state.update { State.Loading }
                }
                else -> {
                    _state.update { State.Error() }
                }
            }
        }
    }

    fun searchAction(text: String){
        filterItems(text)
    }

    private fun filterItems(query: String) {
        val successState = _state.value as? State.Success<List<Recipe>>
        val filtered = if (query.isNotBlank() && successState != null) {
            successState.data.filter { it.name?.contains(query, ignoreCase = true) ?: false }
        } else {
            successState?.data ?: emptyList()
        }
        _filteredList.update { filtered }
    }


}