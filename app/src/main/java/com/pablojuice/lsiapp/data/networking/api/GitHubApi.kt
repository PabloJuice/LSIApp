package com.pablojuice.lsiapp.data.networking.api

import com.pablojuice.lsiapp.data.networking.response.GitHubUserResponse
import retrofit2.http.GET

interface GitHubApi {
    @GET("/users")
    suspend fun getUsers(): GitHubUserResponse?
}