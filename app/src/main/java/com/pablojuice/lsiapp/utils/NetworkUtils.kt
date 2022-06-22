package com.pablojuice.lsiapp.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

object NetworkUtils {
    fun createRetrofit(apiEndPoint: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(apiEndPoint)
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}