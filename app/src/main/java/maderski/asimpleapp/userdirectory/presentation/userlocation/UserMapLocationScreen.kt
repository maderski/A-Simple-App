package maderski.asimpleapp.userdirectory.presentation.userlocation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import maderski.asimpleapp.common.content.ErrorMessageContent

@Composable
fun UserMapLocationScreen(
    companyName: String?,
    locationLat: String?,
    locationLng: String?,
) {
    val lat = locationLat?.toDoubleOrNull()
    val lng = locationLng?.toDoubleOrNull()
    if (lat != null && lng != null) {
        val companyLocation = LatLng(lat, lng)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(companyLocation, 10f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                position = companyLocation,
                title = companyName,
                icon = BitmapDescriptorFactory.defaultMarker(
                    BitmapDescriptorFactory.HUE_RED
                )
            )
        }
    } else {
        ErrorMessageContent(message = "Lat and/or Lng cannot be Null! Lat: $lat Lng: $lng")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserMapLocationScreen() {
    UserMapLocationScreen(
        companyName = "Joe's Repair",
        locationLat = "-37.3159",
        locationLng = "81.1496",
    )
}