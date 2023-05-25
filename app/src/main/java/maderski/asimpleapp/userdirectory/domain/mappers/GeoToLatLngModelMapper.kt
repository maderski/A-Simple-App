package maderski.asimpleapp.userdirectory.domain.mappers

import maderski.asimpleapp.userdirectory.domain.models.LatLngModel
import maderski.asimpleapp.userdirectory.service.models.Geo

class GeoToLatLngModelMapper {
    operator fun invoke(geo: Geo?): LatLngModel? =
        geo?.let {
            if (it.lat != null && it.lng != null) {
                LatLngModel(it.lat, it.lng)
            } else {
                null
            }
        }

}