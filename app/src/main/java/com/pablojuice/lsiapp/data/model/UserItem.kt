package com.pablojuice.lsiapp.data.model

import android.os.Parcelable
import com.pablojuice.lsiapp.core.utils.AppConstants.DAILY_MOTION_USER
import com.pablojuice.lsiapp.core.utils.AppConstants.GIT_HUB_USER
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class UserItem(
    open val userName: String?,
    val userType: String?,
    open val userPhoto: String?
) : Parcelable

class GithubUserItem(
    override val userName: String?,
    override val userPhoto: String?
) : UserItem(
    userName,
    GIT_HUB_USER,
    userPhoto
)

class DailyMotionUserItem(
    override val userName: String?,
    override val userPhoto: String?
) : UserItem(
    userName,
    DAILY_MOTION_USER,
    userPhoto
)