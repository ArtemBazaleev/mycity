package com.mycity.presintation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentNew<T : ViewBinding> : Fragment() {

    companion object {
        private const val BASE_FRAGMENT_TAG = "baseFragmentTag"
    }

    private var navigationController: NavController? = null

    protected val binding: T?
        get() = _binding

    private var _binding: T? = null

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        state: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationController = Navigation.findNavController(view)
    }

    fun addFragment(@IdRes destinationId: Int, vararg data: Arg) {
        val arg = mutableListOf<Pair<String, Any>>()
        data.forEach {
            arg.add(Pair(it.key, it.arg))
        }
        val bundle: Bundle = bundleOf(*arg.toTypedArray())
        navigationController?.navigate(destinationId, bundle)
    }

    fun addFragment(@IdRes destinationId: Int) {
        navigationController?.navigate(destinationId)
    }

    fun popBackStack() {
        navigationController?.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}