package com.pablojuice.lsiapp.data.networking.handlers

import com.pablojuice.lsiapp.core.utils.AppConstants.DAILY_MOTION_API
import com.pablojuice.lsiapp.core.utils.AppConstants.GIT_HUB_API
import com.pablojuice.lsiapp.core.utils.NetworkUtils.createRetrofit
import com.pablojuice.lsiapp.data.networking.api.DailyMotionApi
import com.pablojuice.lsiapp.data.networking.api.GitHubApi
import com.pablojuice.lsiapp.data.networking.response.DailyMotionUserResponse
import com.pablojuice.lsiapp.data.networking.response.GitHubUserResponse

object UserRequestHandler {
    private val gitHubApi: GitHubApi = createRetrofit(GIT_HUB_API).create(GitHubApi::class.java)
    private val dailyMotionApi: DailyMotionApi =
        createRetrofit(DAILY_MOTION_API).create(DailyMotionApi::class.java)

    suspend fun getGitHubUsers(): GitHubUserResponse? = gitHubApi.getUsers()

    suspend fun getDailyMotionUsers(): DailyMotionUserResponse? = dailyMotionApi.getUsers()
}