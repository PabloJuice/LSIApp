package com.pablojuice.lsiapp.networking.handlers

import com.pablojuice.lsiapp.networking.api.DailyMotionApi
import com.pablojuice.lsiapp.networking.api.GitHubApi
import com.pablojuice.lsiapp.networking.response.DailyMotionUserResponse
import com.pablojuice.lsiapp.networking.response.GitHubUserResponse
import com.pablojuice.lsiapp.utils.AppConstants.DAILY_MOTION_API
import com.pablojuice.lsiapp.utils.AppConstants.GIT_HUB_API
import com.pablojuice.lsiapp.utils.NetworkUtils.createRetrofit

object UserRequestHandler {
    private val gitHubApi: GitHubApi = createRetrofit(GIT_HUB_API).create(GitHubApi::class.java)
    private val dailyMotionApi: DailyMotionApi =
        createRetrofit(DAILY_MOTION_API).create(DailyMotionApi::class.java)

    suspend fun getGitHubUsers(): GitHubUserResponse? = gitHubApi.getUsers()

    suspend fun getDailyMotionUsers(): DailyMotionUserResponse? = dailyMotionApi.getUsers()
}