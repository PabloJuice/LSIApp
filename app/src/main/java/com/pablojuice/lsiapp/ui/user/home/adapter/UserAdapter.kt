package com.pablojuice.lsiapp.ui.user.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pablojuice.lsiapp.data.model.UserItem
import com.pablojuice.lsiapp.databinding.ItemUserBinding

class UserAdapter(private val listener: Listener) : RecyclerView.Adapter<UserViewHolder>() {
    private val items: MutableList<UserItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItems(items: List<UserItem>?) {
        items?.also {
            val oldSize = this.items.size
            this.items.addAll(it)
            notifyItemRangeChanged(oldSize, this.items.size)
        }
    }

    interface Listener {
        fun onItemClick(item: UserItem)
    }
}