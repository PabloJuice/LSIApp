package com.pablojuice.lsiapp.ui.user.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.pablojuice.lsiapp.core.ui.BaseFragment
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
}