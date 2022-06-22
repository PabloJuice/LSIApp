package com.pablojuice.lsiapp.ui.user.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pablojuice.lsiapp.R
import com.pablojuice.lsiapp.core.ui.BaseFragment
import com.pablojuice.lsiapp.data.model.UserItem
import com.pablojuice.lsiapp.databinding.FragmentUserDetailsBinding

class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding, UserDetailsViewModel>() {

    override fun bindLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserDetailsBinding {
        return FragmentUserDetailsBinding.inflate(inflater, container, false)
    }

    override fun bindViewModel(): UserDetailsViewModel {
        return ViewModelProvider(this)[UserDetailsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        arguments?.let { setupFromUserItem(UserDetailsFragmentArgs.fromBundle(it).userItem) }
    }

    private fun setupListeners() {
        binding.backButton.setOnClickListener { navigateBack() }
    }

    private fun setupFromUserItem(item: UserItem) {
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