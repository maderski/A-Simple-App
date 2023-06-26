package maderski.asimpleapp.userdirectory.data.mappers

import maderski.asimpleapp.userdirectory.data.models.LatLngModel
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