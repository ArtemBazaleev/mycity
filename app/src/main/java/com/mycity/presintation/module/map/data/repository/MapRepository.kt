package com.mycity.presintation.module.map.data.repository

import com.mycity.presintation.module.map.data.entity.MarkerEntityResponse
import java.lang.Exception

interface MapRepository {

    suspend fun requestMarkersForPosition(
            myPositionLon: Double,
            myPositionLat: Double,
            success: (List<MarkerEntityResponse>) -> Unit,
            fail: (Exception) -> Unit
    )

}