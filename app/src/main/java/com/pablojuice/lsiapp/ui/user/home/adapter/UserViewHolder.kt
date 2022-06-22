package com.pablojuice.lsiapp.ui.user.home.adapter

import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pablojuice.lsiapp.R
import com.pablojuice.lsiapp.data.model.UserItem
import com.pablojuice.lsiapp.databinding.ItemUserBinding

class UserViewHolder(
    private val binding: ItemUserBinding,
    private val listener: UserAdapter.Listener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserItem) {
        binding.root.setOnClickListener { listener.onItemClick(item) }
        item.userName?.also { binding.userName.text = it }
        item.userType?.also { binding.userType.text = it }
        if (item.userPhoto != null) {
            Glide.with(binding.root)
                .load(item.userPhoto)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .format(DecodeFormat.DEFAULT)
                .skipMemoryCache(false)
                .dontAnimate()
                .into(binding.userPhoto)
        } else {
            ResourcesCompat.getDrawable(binding.root.resources, R.drawable.ic_standard_user, null)
                ?.also { binding.userPhoto.setImageDrawable(it) }
        }
    }
}