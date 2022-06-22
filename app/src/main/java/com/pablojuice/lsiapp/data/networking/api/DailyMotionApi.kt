package com.pablojuice.lsiapp.data.networking.api

import com.pablojuice.lsiapp.data.networking.response.DailyMotionUserResponse
import retrofit2.http.GET

interface DailyMotionApi {
    @GET("/users")
    suspend fun getUsers(): DailyMotionUserResponse?
}