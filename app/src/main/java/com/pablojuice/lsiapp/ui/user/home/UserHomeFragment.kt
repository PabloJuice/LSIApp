package com.pablojuice.lsiapp.ui.user.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.pablojuice.lsiapp.core.ui.BaseFragment
import com.pablojuice.lsiapp.databinding.FragmentUserHomeBinding

class UserHomeFragment : BaseFragment<FragmentUserHomeBinding, UserHomeViewModel>() {

    override fun bindLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserHomeBinding {
        return FragmentUserHomeBinding.inflate(inflater, container, false)
    }

    override fun bindViewModel(): UserHomeViewModel {
        return ViewModelProvider(this)[UserHomeViewModel::class.java]
    }
}