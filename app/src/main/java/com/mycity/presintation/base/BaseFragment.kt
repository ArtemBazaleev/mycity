package com.mycity.presintation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment(), Navigator {

    companion object {
        private const val BASE_FRAGMENT_TAG = "baseFragmentTag"
    }

    protected var act: MainActivity? = null


    protected val binding: T?
        get() = _binding

    private var _binding: T? = null

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    override fun onAttach(context: Context) {
        act = activity as? MainActivity
        super.onAttach(context)
    }

    override fun onDetach() {
        act = null
        super.onDetach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        state: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun addFragment(navigationId: Int, addToBackStack: Boolean?) {
        act?.navigation?.addFragment(navigationId)
    }

    override fun addFragment(navigationId: Int, addToBackStack: Boolean?, vararg data: Arg) {
        act?.navigation?.addFragment(navigationId, *data)
    }

    override fun backToCurrentFragment(navigationId: Int) {
        act?.navigation?.backToCurrentFragment(navigationId)
    }

    override fun addFragmentWithAnim(
        navigationId: Int,
        addToBackStack: Boolean?,
        type: AppNavigation.NavigationAnimType
    ) {
       act?.navigation?.addFragmentWithAnim(navigationId, type)
    }

    override fun addFragmentWithAnim(
        navigationId: Int,
        addToBackStack: Boolean?,
        vararg data: Arg,
        type: AppNavigation.NavigationAnimType
    ) {
        act?.navigation?.addFragmentWithAnim(navigationId, *data, type = type)
    }

    override fun popBackStack() {
        act?.navigation?.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}