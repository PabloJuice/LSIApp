package com.pablojuice.lsiapp.ui.user.home

import com.pablojuice.lsiapp.core.ui.BaseViewModel
import com.pablojuice.lsiapp.networking.handlers.UserRequestHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserHomeViewModel : BaseViewModel() {
    fun fetchUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            UserRequestHandler.getGitHubUsers()?.forEach {
                println(it)
            }

            UserRequestHandler.getDailyMotionUsers()?.users?.forEach {
                println(it)
            }
        }
    }
}