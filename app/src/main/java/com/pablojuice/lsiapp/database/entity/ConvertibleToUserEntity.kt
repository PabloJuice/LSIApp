package com.pablojuice.lsiapp.database.entity

interface ConvertibleToUserItem {
    fun toUserItem(): UserItem
}