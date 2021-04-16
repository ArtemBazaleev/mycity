package com.mycity.presintation.base

import androidx.annotation.IdRes

interface Navigator {
    fun addFragment(@IdRes navigationId: Int, addToBackStack: Boolean? = null)
    fun addFragment(@IdRes navigationId: Int, addToBackStack: Boolean? = null, vararg data: Arg)
    fun addFragmentWithAnim(
        @IdRes navigationId: Int,
        addToBackStack: Boolean? = null,
        type: AppNavigation.NavigationAnimType
    )
    fun addFragmentWithAnim(
        @IdRes navigationId: Int,
        addToBackStack: Boolean? = null,
        vararg data: Arg,
        type: AppNavigation.NavigationAnimType
    )
    fun popBackStack()
    fun backToCurrentFragment(@IdRes navigationId: Int)
}