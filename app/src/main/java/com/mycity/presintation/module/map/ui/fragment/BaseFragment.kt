package com.mycity.presintation.module.map.ui.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.mycity.presintation.module.map.ui.MainActivity
import com.mycity.presintation.module.map.ui.navigation.Arg

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    companion object {
        private const val TAG = "baseFragment"
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun addFragment(@IdRes destinationId: Int) {
        act?.navigator?.addFragment(destinationId)
    }

    fun addFragment(destinationId: Int, vararg data: Arg) {
        act?.navigator?.addFragment(destinationId, *data)
    }

    fun popBackStack() = act?.navigator?.popBackStack()

    fun addFragment(
        @IdRes destinationId: Int,
        @AnimRes enterAnim: Int,
        @AnimRes exitAnim: Int,
        @AnimRes popEnterAnim: Int,
        @AnimRes popExitAnim: Int
    ) {
        act?.navigator?.addFragment(
            destinationId,
            enterAnim,
            exitAnim,
            popEnterAnim,
            popExitAnim
        )
    }

    fun addFragment(
        @IdRes destinationId: Int,
        @AnimRes enterAnim: Int,
        @AnimRes exitAnim: Int,
        @AnimRes popEnterAnim: Int,
        @AnimRes popExitAnim: Int,
        vararg data: Arg
    ) {
        act?.navigator?.addFragment(
            destinationId,
            enterAnim,
            exitAnim,
            popEnterAnim,
            popExitAnim,
            *data
        )
    }

    fun getController() = act?.navigator?.getController()

    fun getCurrentFragment() = act?.navigator?.getCurrentFragment()

    fun showAlert(
        title: String,
        message: String,
        positiveButtonText: String? = null,
        positiveButtonListener: (() -> Unit)? = null,
        negativeButtonText: String? = null,
        negativeButtonListener: (() -> Unit)? = null
    ) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveButtonText) { dialog, which ->
                positiveButtonListener?.invoke()
            }
            .setNegativeButton(negativeButtonText) { dialog, which ->
                negativeButtonListener?.invoke()
            }
            .show()

    }
}