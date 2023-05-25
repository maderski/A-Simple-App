package maderski.asimpleapp.userdirectory.domain.models

data class AddressModel(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val latLng: LatLngModel?,
)
