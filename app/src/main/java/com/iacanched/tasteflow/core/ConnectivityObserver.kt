package com.iacanched.tasteflow.core
import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun observe(): Flow<Status>
    fun isConnected(): Boolean

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}