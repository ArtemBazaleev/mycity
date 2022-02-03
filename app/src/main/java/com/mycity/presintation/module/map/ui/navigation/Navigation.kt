package com.mycity.presintation.module.map.ui.navigation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView

fun createNavigationArgs(vararg args: Arg): Bundle {
    val list = mutableListOf<Pair<String, Any>>()
    args.forEach { arg ->
        list.add(Pair(arg.key, arg.arg))
    }

    return bundleOf(*list.toTypedArray())
}

fun setUpWithNavController(
    bottomNav: BottomNavigationView?,
    controller: NavController?
) {
    if (bottomNav != null && controller != null)
        NavUtils.setUpWithBottomNav(bottomNav, controller)
}
