package com.pablojuice.lsiapp.ui.user.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pablojuice.lsiapp.R
import com.pablojuice.lsiapp.core.ui.BaseFragment
import com.pablojuice.lsiapp.data.model.UserItem
import com.pablojuice.lsiapp.databinding.FragmentUserHomeBinding
import com.pablojuice.lsiapp.ui.user.home.adapter.UserAdapter

class UserHomeFragment :
    BaseFragment<FragmentUserHomeBinding, UserHomeViewModel>(),
    UserAdapter.Listener {
    private val userAdapter: UserAdapter = UserAdapter(this)

    override fun bindLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserHomeBinding {
        return FragmentUserHomeBinding.inflate(inflater, container, false)
    }

    override fun bindViewModel(): UserHomeViewModel {
        return ViewModelProvider(this)[UserHomeViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupListeners()
        viewModel.fetchUsers()
    }

    private fun setupListeners() {
        viewModel.users.observe(viewLifecycleOwner) {
            userAdapter.addItems(it)
        }
    }

    private fun setupRecycler() {
        binding.userRecycler.layoutManager = LinearLayoutManager(context)
        ResourcesCompat.getDrawable(
            resources,
            R.drawable.ic_custom_divider,
            null
        )?.let { drawable ->
            binding.userRecycler.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                ).apply { setDrawable(drawable) }
            )
        }
        binding.userRecycler.adapter = userAdapter
    }

    override fun onItemClick(item: UserItem) {
        navigate(
            UserHomeFragmentDirections.actionUserHomeFragmentToUserDetailsFragment(item)
        )
    }
}