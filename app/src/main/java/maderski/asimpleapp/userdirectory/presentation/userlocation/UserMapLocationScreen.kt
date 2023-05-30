package maderski.asimpleapp.userdirectory.presentation.userlocation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
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
import maderski.asimpleapp.common.content.LoadingContent
import maderski.asimpleapp.userdirectory.presentation.userlocation.UserMapLocationViewModel.*

@Composable
fun UserMapLocationScreen(
    companyName: String?,
    locationLat: String?,
    locationLng: String?,
    viewModel: UserMapLocationViewModel = hiltViewModel()
) {
    val screenState by viewModel.screenState.collectAsState()
    HandleScreenState(state = screenState)

    viewModel.init(companyName, locationLat, locationLng)
}

@Composable
private fun HandleScreenState(state: UIState) {
    when (state) {
        UIState.Loading -> LoadingContent()
        is UIState.ShowingMap -> {
            val companyLocation = state.latLng
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(companyLocation, 5f)
            }
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    position = companyLocation,
                    title = state.companyName,
                    icon = BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_RED
                    )
                )
            }
        }
        is UIState.ErrorOccurred -> ErrorMessageContent(message = state.message)
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