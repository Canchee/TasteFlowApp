package com.iacanched.tasteflow.data.network

sealed interface NetworkResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>
    data class Error(val errorMessage: String) : NetworkResult<Nothing>
    class Exception(val e: Throwable) : NetworkResult<Nothing>
    object Loading : NetworkResult<Nothing>
}