package com.pablojuice.lsiapp.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding, VM : BaseViewModel> : Fragment() {
    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected lateinit var navController: NavController

    protected abstract fun bindLayout(inflater: LayoutInflater, container: ViewGroup?): B

    protected abstract fun bindViewModel(): VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = bindLayout(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = bindViewModel()
        navController = findNavController(requireView())
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    protected open fun navigate(destination: NavDirections) {
        navController.currentDestination?.getAction(destination.actionId)
            ?.also { navController.navigate(destination) }
    }

    protected open fun navigate(@IdRes resId: Int) {
        navController.currentDestination?.getAction(resId)
            ?.also { navController.navigate(it.destinationId) }
    }
}