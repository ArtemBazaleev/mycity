package com.mycity.presintation.module.map.data.repository

import com.mycity.presintation.module.map.data.entity.MarkerEntityResponse
import com.mycity.presintation.module.map.data.provider.IMapDataProvider
import java.lang.Exception
import javax.inject.Inject

class MapRepositoryImp @Inject constructor(
        private val dataProvider: IMapDataProvider
) : MapRepository {

    override suspend fun requestMarkersForPosition(myPositionLon: Double,
                                                   myPositionLat: Double,
                                                   success: (List<MarkerEntityResponse>) -> Unit,
                                                   fail: (Exception) -> Unit) {

        try {
            val result = dataProvider.getMarkers(myPositionLat, myPositionLon)
            success(result)
        }catch (e: Exception) {
            fail(e)
        }
    }
}