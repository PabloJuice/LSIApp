package com.pablojuice.lsiapp.ui.user.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pablojuice.lsiapp.databinding.ItemUserBinding

class UserViewHolder(
    private val binding: ItemUserBinding,
    private val listener: UserAdapter.Listener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserItem) {
        item.userName?.also { binding.userName.text = it }
        item.userType?.also { binding.userType.text = it }
        item.userPhoto?.also {
            Glide.with(binding.root)
                .load(it)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .format(DecodeFormat.DEFAULT)
                .skipMemoryCache(false)
                .dontAnimate()
                .into(binding.userPhoto)
        }
    }
}