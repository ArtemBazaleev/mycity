package com.mycity.presintation.module.map.data.provider

import com.mycity.presintation.module.map.data.entity.MarkerEntityResponse

class FakeApiGenerator: IMapDataProvider {

    override fun getMarkers(lat: Double, lon: Double): List<MarkerEntityResponse> {
        val list = mutableListOf<MarkerEntityResponse>()
        for (i in 0..20) {
            list.add(MarkerEntityResponse(
                    markerLon = 151.0 + i * 0.01,
                    markerLat = -34.0 + i * 0.01
            ))
        }
        return list
    }
}