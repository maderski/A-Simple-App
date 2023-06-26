package maderski.asimpleapp.userdirectory.data.mappers

import maderski.asimpleapp.userdirectory.data.models.AddressModel
import maderski.asimpleapp.userdirectory.service.models.Address
import javax.inject.Inject

class AddressToAddressModelMapper @Inject constructor(
    private val latLngMapper: GeoToLatLngModelMapper,
) {
    // TODO: Improve handling of null address fields
    operator fun invoke(address: Address?): AddressModel? =
        address?.let {
            AddressModel(
                it.street ?: "Unknown",
                it.suite ?: "",
                it.city ?: "",
                it.zipcode ?: "",
                latLngMapper(it.geo)
            )
        }
}