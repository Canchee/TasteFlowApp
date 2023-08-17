package com.iacanched.tasteflow.core

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkInterceptor @Inject constructor(private val connectivityObserver: ConnectivityObserver) :
    Interceptor {
    private val auth = "sQBe5TNCsRUVpHDeILtLv0hrP2Lo5xUNX0cf0MfBI3fVxLhhCuF1kW5F"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", auth)
            .build()
        return chain.proceed(request)
    }

}