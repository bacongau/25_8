package com.example.a25.api

import android.content.Context
import com.example.a25.exception.NoInternetConnectionException
import com.example.a25.utils.Utils
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor constructor(val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!Utils().checkNetwork(context)) {
            throw NoInternetConnectionException()
        }
        val builer = chain.request().newBuilder()
        return chain.proceed(builer.build())
    }
}
