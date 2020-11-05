package com.android.navigation.base

import androidx.fragment.app.Fragment

//The Fragment that holds the BottomNavigationBar needs to extend this class
abstract class BottomNavigationHolderFragment: Fragment() {

    abstract val bottomNavBarHeight: Int?
}
