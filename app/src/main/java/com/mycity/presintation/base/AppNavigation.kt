package com.mycity.presintation.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.mycity.R
import java.lang.Exception

/**
 * Класс для работы с навигации приложения
 */
class AppNavigation(
    private var context: Context
) {

    private var navigation: NavController? = null

    companion object {
        const val APP_NAVIGATION_TAG = "appNavigationTag"

    }

    /**
     * Обязательно вызвать этот метод
     * Получает NavHostFragment и инициализируется NavController
     */
    fun initBase() {
        try {
            val navHostFragment = getFragmentManager()?.findFragmentById(R.id.fl_root) as NavHostFragment
            navigation = navHostFragment.navController
        } catch (e: Exception) {
            Log.d(APP_NAVIGATION_TAG, "error getting nav controller: $e")
        }
    }

    fun addFragment(@IdRes destinationId: Int, vararg data: Arg) {
        val arg = mutableListOf<Pair<String, Any>>()
        data.forEach {
            arg.add(Pair(it.key, it.arg))
            Log.d(APP_NAVIGATION_TAG, "ar: $it")
        }
        val bundle: Bundle = bundleOf(*arg.toTypedArray())
        navigation?.navigate(destinationId, bundle)
    }


    fun addFragment(@IdRes destinationId: Int) {
        Log.d(APP_NAVIGATION_TAG, "addFragment destination -> $destinationId")
        navigation?.navigate(destinationId)
    }

    fun popBackStack() {
        navigation?.popBackStack()
    }

    fun backToCurrentFragment(@IdRes destinationId: Int) {
        navigation?.popBackStack(destinationId, true)
    }

    /**
     * Методы открытия фрагментов с анимацией
     */
    fun addFragmentWithAnim(@IdRes destinationId: Int, type: NavigationAnimType) {
        val navOptionBuilder = NavOptions.Builder()
        navOptionBuilder.apply {
            when (type) {
                NavigationAnimType.MOVE_TO_RIGHT -> {

                }
                NavigationAnimType.MOVE_TO_UP -> {

                }
            }
            navigation?.navigate(destinationId, null, navOptionBuilder.build())
        }
    }

    fun addFragmentWithAnim(
        @IdRes destinationId: Int,
        vararg data: Arg,
        type: NavigationAnimType
    ) {
        val navOptionBuilder = NavOptions.Builder()
        navOptionBuilder.apply {
            when (type) {
                NavigationAnimType.MOVE_TO_UP -> {

                }
                NavigationAnimType.MOVE_TO_RIGHT -> {

                }
            }
        }
        val arg = mutableListOf<Pair<String, Any>>()
        data.forEach {
            arg.add(Pair(it.key, it.arg))
            Log.d(APP_NAVIGATION_TAG, "ar: $it")
        }
        val bundle: Bundle = bundleOf(*arg.toTypedArray())
        navigation?.navigate(destinationId, bundle, navOptionBuilder.build())
    }

    private fun getFragmentManager(): FragmentManager? {
        return try {
            (context as MainActivity).supportFragmentManager
        } catch (e: Exception) {
            Log.d(APP_NAVIGATION_TAG, "error getting fm: $e")
            null
        }
    }


    /**
     * Нужно выбрать тип анимации, если нужно сделать через код
     */
    enum class NavigationAnimType {
        MOVE_TO_RIGHT,
        MOVE_TO_UP
    }
}