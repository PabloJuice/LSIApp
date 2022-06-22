package com.pablojuice.lsiapp.networking.api

import com.pablojuice.lsiapp.networking.response.DailyMotionUserResponse
import retrofit2.http.GET

interface DailyMotionApi {
    @GET("/users")
    suspend fun getUsers(): DailyMotionUserResponse?
}