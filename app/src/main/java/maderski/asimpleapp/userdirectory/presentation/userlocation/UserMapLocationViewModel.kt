package maderski.asimpleapp.userdirectory.presentation.userlocation

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UserMapLocationViewModel @Inject constructor() : ViewModel() {
    sealed interface UIState {
        object Loading : UIState
        data class ShowingMap(
            val companyName: String,
            val latLng: LatLng,
        ) : UIState

        data class ErrorOccurred(val message: String) : UIState
    }

    val screenState: StateFlow<UIState>
        get() = _screenState
    private val _screenState = MutableStateFlow<UIState>(UIState.Loading)

    fun init(
        companyName: String?,
        locationLat: String?,
        locationLng: String?,
    ) {
        val lat = locationLat?.toDoubleOrNull()
        val lng = locationLng?.toDoubleOrNull()
        val name = companyName ?: "Unknown"
        if (lat != null && lng != null) {
            _screenState.value = UIState.ShowingMap(name, LatLng(lat, lng))
        } else {
            _screenState.value = UIState.ErrorOccurred(
                "Lat and/or Lng cannot be Null! Lat: $lat Lng: $lng"
            )
        }
    }
}