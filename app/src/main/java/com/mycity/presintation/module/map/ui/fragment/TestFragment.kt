package com.mycity.presintation.module.map.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mycity.databinding.FragmentTestBinding
import com.mycity.presintation.base.BaseFragment

class TestFragment : BaseFragment<FragmentTestBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTestBinding
        get() = FragmentTestBinding::inflate


}