package com.mycity.presintation.module.map.ui.navigation

import androidx.annotation.AnimRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController

/**
 * interface для работы с навигацией приложения
 * Будет реализован в NavigationController
 * graph навигации: navigation -> app_graph
 */
interface Navigator {

    /**
     * Данный метод добавляет фрагмент
     * @param destinationId - id / destination id фрагмента
     */
    fun addFragment(@IdRes destinationId: Int)

    /**
     * Метод добавляет фрагмент, но возможно передать аргументы
     * @param destinationId - id / destination id фрагмента
     * @param args - аргументы для Bundle
     */
    fun addFragment(@IdRes destinationId: Int, vararg args: Arg)


    /**
     * Метод возвращает по backstack
     */
    fun popBackStack()

    /**
     * Добавляет фрагмент, но можно еще передать ресурс с анимацией
     * @param destinationId - id фрагмента, который указан в app_graph или destination id
     */
    fun addFragment(
        @IdRes destinationId: Int,
        @AnimRes enterAnim: Int,
        @AnimRes exitAnim: Int,
        @AnimRes popEnterAnim: Int,
        @AnimRes popExitAnim: Int
    )

    /**
     * Добавляет фрагмент, но можно еще передать ресурс с анимацией
     * @param destinationId - id фрагмента, который указан в app_graph или destination id
     * @param data - Аргументы для bundle
     */
    fun addFragment(
        @IdRes destinationId: Int,
        @AnimRes enterAnim: Int,
        @AnimRes exitAnim: Int,
        @AnimRes popEnterAnim: Int,
        @AnimRes popExitAnim: Int,
        vararg data: Arg
    )

    /**
     * Возвращает текущий фрагмент
     */
    fun getCurrentFragment() : Fragment?

    /**
     * Возвращает NavController
     */
    fun getController() : NavController?
}