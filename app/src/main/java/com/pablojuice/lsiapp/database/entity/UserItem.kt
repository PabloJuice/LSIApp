package com.pablojuice.lsiapp.database.entity

import com.pablojuice.lsiapp.utils.AppConstants.DAILY_MOTION_USER
import com.pablojuice.lsiapp.utils.AppConstants.GIT_HUB_USER

sealed class UserItem(
    val userName: String?,
    val userType: String?,
    val userPhoto: String?
)

class GithubUserItem(
    userName: String?,
    userPhoto: String?
) : UserItem(
    userName,
    GIT_HUB_USER,
    userPhoto
)

class DailyMotionUserItem(
    userName: String?,
    userPhoto: String?
) : UserItem(
    userName,
    DAILY_MOTION_USER,
    userPhoto
)