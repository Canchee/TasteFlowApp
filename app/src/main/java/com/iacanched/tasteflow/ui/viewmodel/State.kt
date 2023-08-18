package com.iacanched.tasteflow.ui.viewmodel

sealed interface State<out T : Any> {
    object Loading : State<Nothing>
    data class Success<out T : Any>(val data: T)  : State<T>
    data class Error(val throwable: Throwable? = null) : State<Nothing>

    fun extractRecipe(): T? {
        return when (this) {
            is Success -> data
            else -> null
        }
    }
}