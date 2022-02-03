package com.mycity.presintation.module.map.domain

import com.mycity.presintation.base.BaseUseCaseCoroutine
import com.mycity.presintation.base.DefParams
import com.mycity.presintation.module.map.data.entity.MarkerEntityResponse
import com.mycity.presintation.module.map.data.repository.MapRepository
import java.lang.Exception
import javax.inject.Inject

class GetMapMarkersUseCase @Inject constructor(
    private val repository: MapRepository
) : BaseUseCaseCoroutine<GetMapMarkersParams, List<MarkerEntityResponse>> {

    override suspend fun execute(
        params: GetMapMarkersParams,
        success: (List<MarkerEntityResponse>) -> Unit,
        fail: (Exception) -> Unit
    ) {
        repository.requestMarkersForPosition(
            myPositionLat = params.lat,
            myPositionLon = params.lng,
            success = success,
            fail = fail
        )
    }

}


class GetMapMarkersParams(
    var lat: Double,
    var lng: Double
): DefParams()
