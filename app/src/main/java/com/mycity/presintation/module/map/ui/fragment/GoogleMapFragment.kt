package com.mycity.presintation.module.map.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mycity.R
import com.mycity.databinding.FragmentGoogleMapBinding
import com.mycity.presintation.module.map.data.entity.MarkerEntityResponse

class GoogleMapFragment : BaseMapFragment<FragmentGoogleMapBinding>() {

    private var gMap: GoogleMap? = null

    private val callback = OnMapReadyCallback { googleMap ->
        gMap = googleMap
        val sydney = LatLng(-34.0, 151.0)
        gMap?.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        gMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        initMarkers()
    }

    private fun initMarkers() {
        mapViewModel?.requestMarkers()
        gMap?.setOnMarkerClickListener {
            Toast.makeText(context, "${it.id}", Toast.LENGTH_SHORT).show()
            true
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGoogleMapBinding
        get() = FragmentGoogleMapBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun handleMarkers(markers: List<MarkerEntityResponse>?) {
        markers?.forEach {
            val location = LatLng(it.markerLat, it.markerLon)
            val marker = gMap?.addMarker(MarkerOptions().position(location))
            marker?.tag = it.markerLat+it.markerLon
        }
    }
}