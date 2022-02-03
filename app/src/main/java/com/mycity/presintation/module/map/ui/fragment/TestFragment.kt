package com.mycity.presintation.module.map.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.mycity.App
import com.mycity.databinding.FragmentTestBinding
import com.mycity.presintation.module.map.ui.navigation.Navigator
import com.mycity.presintation.module.map.ui.viewModel.TestViewModel
import javax.inject.Inject

class TestFragment : BaseFragment<FragmentTestBinding>() {

    private val viewModel by viewModels<TestViewModel>()

    @Inject
    lateinit var navigator: Navigator

    init {
        App.actSubComponent?.inject(this)
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTestBinding
        get() = FragmentTestBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnTest?.setOnClickListener {
            navigator.popBackStack()
        }
    }
}