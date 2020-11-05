package com.android.navigation.base

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import com.android.navigation.extensions.realParentFragment

//The Fragment that represents an BottomNavigationView item needs to extend this class
abstract class BottomNavigationItemFragment: Fragment()
{
    abstract val rootView: View?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().post {
            updateBottomPaddingIfNeeded()
        }
    }

    private fun updateBottomPaddingIfNeeded() {
        val parentFragment = realParentFragment<BottomNavigationHolderFragment>()
        val rootView = this.rootView ?: return
        val bottomNavBarHeight = parentFragment?.bottomNavBarHeight ?: return

        rootView.updatePadding(bottom = bottomNavBarHeight)
    }
}
