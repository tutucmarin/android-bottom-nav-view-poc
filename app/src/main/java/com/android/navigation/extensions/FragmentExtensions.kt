package com.android.navigation.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

//Unwraps the NavHostFragment and returns the real parent Fragment
@Suppress("UNCHECKED_CAST")
fun <T : Fragment> Fragment.realParentFragment() : T?
{
    val navHost = parentFragment as? NavHostFragment

    return navHost?.parentFragment as? T?
}
