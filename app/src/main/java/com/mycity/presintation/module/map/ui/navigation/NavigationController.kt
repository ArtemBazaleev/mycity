package com.mycity.presintation.module.map.ui.navigation

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.mycity.R

class NavigationController constructor(
    private val fm: FragmentManager
) : Navigator {

    private var navHostFragment: NavHostFragment? = null
    private var navController: NavController? = null

    companion object {
        const val TAG = "navController"
    }

    init {
        initBase()
    }

    private fun initBase() {
        try {
            navHostFragment =
                fm.findFragmentById(R.id.fl_root) as? NavHostFragment
            navController = navHostFragment?.navController

        } catch (e: Exception) {
            e.printStackTrace()
            Log.d(TAG, "error getting nav controller: $e")
        }


    }

    override fun addFragment(destinationId: Int) {
        Log.d(TAG, "destination id: $destinationId")
        navController?.navigate(destinationId)
    }

    override fun addFragment(destinationId: Int, vararg args: Arg) {
        Log.d(TAG, "destination id: $destinationId")
        val bundle = createNavigationArgs(*args)
        navController?.navigate(destinationId, bundle)
    }

    override fun addFragment(
        destinationId: Int,
        enterAnim: Int,
        exitAnim: Int,
        popEnterAnim: Int,
        popExitAnim: Int
    ) {
        Log.d(TAG, "destination id: $destinationId")
        val navOption = navOptions {
            anim {
                enter = enterAnim
                exit = exitAnim
                popEnter = popEnterAnim
                popExit = popExitAnim
            }
        }
        navController?.navigate(destinationId, null, navOption)
    }

    override fun addFragment(
        destinationId: Int,
        enterAnim: Int,
        exitAnim: Int,
        popEnterAnim: Int,
        popExitAnim: Int,
        vararg data: Arg
    ) {
        Log.d(TAG, "destination id: $destinationId")
        val bundleArgs = createNavigationArgs(*data)
        val navOption = navOptions {
            anim {
                enter = enterAnim
                exit = exitAnim
                popEnter = popEnterAnim
                popExit = popExitAnim
            }
        }
        navController?.navigate(destinationId, bundleArgs, navOption)
    }

    override fun popBackStack() {
        navController?.popBackStack()
    }

    override fun getCurrentFragment() = try {
        navHostFragment?.childFragmentManager?.fragments?.get(0)

    } catch (e: Exception) {
        null
    }


    override fun getController() = try {
        navController

    } catch (e: Exception) {
        null
    }

}