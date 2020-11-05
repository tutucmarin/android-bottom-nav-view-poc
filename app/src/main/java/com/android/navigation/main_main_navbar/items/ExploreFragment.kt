package com.android.navigation.main_main_navbar.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.navigation.R
import com.android.navigation.base.BottomNavigationItemFragment


class ExploreFragment : BottomNavigationItemFragment() {

    override val rootView: View?
        get() = view

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }
}