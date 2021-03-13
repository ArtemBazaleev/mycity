package com.mycity.presintation.module.map.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mycity.databinding.FragmentGoogleMapBinding

class GoogleMapFragment: BaseMapFragment<FragmentGoogleMapBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGoogleMapBinding
        get() = FragmentGoogleMapBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}