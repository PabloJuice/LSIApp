package com.pablojuice.lsiapp.networking.response

import com.google.gson.annotations.SerializedName
import com.pablojuice.lsiapp.database.entity.ConvertibleToUserItem
import com.pablojuice.lsiapp.database.entity.DailyMotionUserItem
import com.pablojuice.lsiapp.database.entity.UserItem

data class DailyMotionUserResponse(
    val page: Long,
    val limit: Long,
    val explicit: Boolean,
    val total: Long,
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("list")
    val users: List<DailyMotionUser>
)

data class DailyMotionUser(
    val id: String,
    @SerializedName("screenname")
    val screenName: String
) : ConvertibleToUserItem {

    override fun toUserItem(): UserItem {
        return DailyMotionUserItem(screenName, null)
    }
}
