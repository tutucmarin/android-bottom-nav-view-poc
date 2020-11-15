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
import com.bumptech.glide.Glide
import com.google.android.material.shape.CornerFamily


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

        configCardView()

        binding.navigateButton.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchResultsFragment)
        }

        binding.selectLikedTabButton.setOnClickListener {
            realParentFragment<MainNavigationFragment>()?.selectTabWithId(R.id.liked_main_navigation)
        }


        Glide.with(requireContext())
            .load("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-bmw-3-series-mmp-1-1593549868.jpg?crop=0.938xw:0.781xh;0.0128xw,0.0373xh&resize=1200:*")
            .into(binding.imageView)
    }

    private fun configCardView()
    {
        val leftCorner = 0f
        val rightCorner = 32f

        binding.cardView.apply {

            shapeAppearanceModel = shapeAppearanceModel.toBuilder()
                    .setTopLeftCorner(CornerFamily.CUT, leftCorner)
                    .setTopRightCorner(CornerFamily.ROUNDED, rightCorner)
                    .setBottomLeftCorner(CornerFamily.CUT, leftCorner)
                    .setBottomRightCorner(CornerFamily.ROUNDED, rightCorner)
                    .build()
        }

        binding.imageView.apply {

            shapeAppearanceModel = shapeAppearanceModel.toBuilder()
                    .setTopLeftCorner(CornerFamily.CUT, leftCorner)
                    .setTopRightCorner(CornerFamily.ROUNDED, rightCorner)
                    .setBottomLeftCorner(CornerFamily.CUT, leftCorner)
                    .setBottomRightCorner(CornerFamily.ROUNDED, rightCorner)
                    .build()
        }

        binding.executePendingBindings()
    }
}