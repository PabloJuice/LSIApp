package com.pablojuice.lsiapp.data.networking.response

import com.google.gson.annotations.SerializedName
import com.pablojuice.lsiapp.data.model.ConvertibleToUserItem
import com.pablojuice.lsiapp.data.model.DailyMotionUserItem
import com.pablojuice.lsiapp.data.model.UserItem

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
