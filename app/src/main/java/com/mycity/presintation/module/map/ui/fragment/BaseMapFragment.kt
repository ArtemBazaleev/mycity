package com.mycity.presintation.module.map.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewbinding.ViewBinding
import com.mycity.presintation.base.BaseFragmentNew
import com.mycity.presintation.module.map.data.entity.MarkerEntityResponse
import com.mycity.presintation.module.map.ui.viewModel.MapViewModel

abstract class BaseMapFragment<T : ViewBinding> : BaseFragmentNew<T>() {

    protected var mapViewModel: MapViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mapViewModel = ViewModelProvider(this).get(MapViewModel::class.java)
        initListeners()
    }

    private fun initListeners() {
        mapViewModel?.liveMarkers?.observe(viewLifecycleOwner, Observer {
            handleMarkers(it)
        })
    }

    abstract fun handleMarkers(markers: List<MarkerEntityResponse>?)

}