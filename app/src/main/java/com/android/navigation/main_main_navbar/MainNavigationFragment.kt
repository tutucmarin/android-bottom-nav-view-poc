package com.android.navigation.main_main_navbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.android.navigation.MainActivity
import com.android.navigation.R
import com.android.navigation.base.BottomNavigationHolderFragment
import com.android.navigation.databinding.FragmentMainNavigationBinding
import com.android.navigation.extensions.setupWithNavController

class MainNavigationFragment : BottomNavigationHolderFragment() {

    private lateinit var binding: FragmentMainNavigationBinding

    private var currentNavController: LiveData<NavController>? = null

    override val bottomNavBarHeight: Int?
        get() {
            return binding.bottomNavigationView.height
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainNavigationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        setupBottomNavigationBar()

        (activity as? MainActivity)?.let {
            it.actionBar?.setDisplayHomeAsUpEnabled(true)
            NavigationUI.setupActionBarWithNavController(it, findNavController())
        }
    }

    private fun setupBottomNavigationBar()
    {
        val navGraphIds = listOf(
            R.navigation.search_main_navigation,
            R.navigation.explore_main_navigation,
            R.navigation.liked_main_navigation,
            R.navigation.history_main_navigation,
            R.navigation.settings_main_navigation
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.mainFragmentContainer
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(viewLifecycleOwner, Observer { navController ->
            setCurrentNavigationController(navController)
        })

        currentNavController = controller
    }

    private fun setCurrentNavigationController(navController : NavController)
    {
        navController.addOnDestinationChangedListener { controller, destination, _ ->

            toggleBottomBarVisibility(destination.id == controller.graph.startDestination)
        }
    }

    private fun toggleBottomBarVisibility(visible : Boolean)
    {
        if (visible)
        {
            showBottomBar()
        }
        else
        {
            hideBottomBar()
        }
    }

    private fun showBottomBar()
    {
        binding.bottomNavigationView
            .animate()
            .translationY(0f)
            .duration = 200
    }

    private fun hideBottomBar()
    {
        val height = binding.bottomNavigationView.height.toFloat()

        binding.bottomNavigationView
            .animate()
            .translationY(height)
            .duration = 200
    }

    //region Public API

    fun selectTabWithId(@IdRes tabId: Int)
    {
        binding.bottomNavigationView.selectedItemId = tabId
    }

    //endregion
}