package com.mycity.presintation.module.map.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.mycity.databinding.FragmentTestBinding
import com.mycity.presintation.module.map.ui.viewModel.TestViewModel

class TestFragment : BaseFragment<FragmentTestBinding>() {

    private val viewModel by viewModels<TestViewModel>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTestBinding
        get() = FragmentTestBinding::inflate
}