package com.pablojuice.lsiapp.networking.api

import com.pablojuice.lsiapp.networking.response.GitHubUserResponse
import retrofit2.http.GET

interface GitHubApi {
    @GET("/users")
    suspend fun getUsers(): GitHubUserResponse?
}