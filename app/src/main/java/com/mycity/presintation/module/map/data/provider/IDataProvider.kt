package com.mycity.presintation.module.map.data.provider

import com.mycity.presintation.module.map.data.entity.MarkerEntityResponse

interface IMapDataProvider {
    fun getMarkers(lat: Double, lon: Double): List<MarkerEntityResponse>
}