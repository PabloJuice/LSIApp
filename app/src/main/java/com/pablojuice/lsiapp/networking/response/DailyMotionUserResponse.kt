package com.pablojuice.lsiapp.networking.response

import com.google.gson.annotations.SerializedName

data class DailyMotionUserResponse(
    val page: Long,
    val limit: Long,
    val explicit: Boolean,
    val total: Long,
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("list")
    val users: List<DailyMotionApiUser>
)

data class DailyMotionApiUser(
    val id: String,
    @SerializedName("screenname")
    val screenName: String
)
