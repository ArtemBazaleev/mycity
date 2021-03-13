package com.mycity.presintation.module.map.ui.viewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mycity.App
import com.mycity.presintation.module.map.data.entity.MarkerEntityResponse
import com.mycity.presintation.module.map.domain.GetMapMarkersParams
import com.mycity.presintation.module.map.domain.GetMapMarkersUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.ln

class MapViewModel: ViewModel() {

    @Inject
    lateinit var app: App

    @Inject
    lateinit var markers: GetMapMarkersUseCase

    init {
        App.component.inject(this)
    }

    val liveMarkers: MutableLiveData<List<MarkerEntityResponse>> = MutableLiveData()

    fun requestMarkers(lat: Double = 0.0, lng: Double = 0.0) {
        app.applicationContext
        viewModelScope.launch {
            markers.execute(
                params = GetMapMarkersParams(lat, lng),
                success = {
                    liveMarkers.postValue(it)
                },
                fail = {

                }
            )
        }
    }

}