package com.android.navigation.main_main_navbar.items.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.navigation.R
import com.android.navigation.base.BottomNavigationItemFragment
import com.android.navigation.databinding.FragmentSearchBinding
import com.android.navigation.extensions.realParentFragment
import com.android.navigation.main_main_navbar.MainNavigationFragment


class SearchFragment : BottomNavigationItemFragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override val rootView: View?
        get() = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigateButton.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchResultsFragment)
        }

        binding.selectLikedTabButton.setOnClickListener {
            realParentFragment<MainNavigationFragment>()?.selectTabWithId(R.id.liked_main_navigation)
        }
    }
}