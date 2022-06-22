package com.pablojuice.lsiapp.ui.user.home

import androidx.lifecycle.MutableLiveData
import com.pablojuice.lsiapp.core.ui.BaseViewModel
import com.pablojuice.lsiapp.data.model.ConvertibleToUserItem
import com.pablojuice.lsiapp.data.model.UserItem
import com.pablojuice.lsiapp.data.networking.handlers.UserRequestHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserHomeViewModel : BaseViewModel() {
    val users: MutableLiveData<List<UserItem>> = MutableLiveData()

    fun fetchUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            if (users.value == null) {
                users.postValue(UserRequestHandler.getGitHubUsers()?.toUserItemList())
                users.postValue(UserRequestHandler.getDailyMotionUsers()?.users?.toUserItemList())
            }
        }
    }

    private fun Iterable<ConvertibleToUserItem>.toUserItemList(): List<UserItem> {
        return this.map { it.toUserItem() }
    }
}