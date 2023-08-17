package com.iacanched.tasteflow.ui.viewmodel

import com.iacanched.tasteflow.domain.model.Recipe

sealed interface State<out T : Any> {
    object Loading : State<Nothing>
    data class Success<out T : Any>(val data: T)  : State<T>
    data class Error(val throwable: Throwable? = null) : State<Nothing>
}