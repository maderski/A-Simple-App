package maderski.asimpleapp.userdirectory.presentation.userlocation.models

import com.google.android.gms.maps.model.LatLng

data class UserMapLocationData(
    val companyName: String,
    val latLng: LatLng,
)