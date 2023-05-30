package maderski.asimpleapp.userdirectory.presentation.userlocation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserMapLocationViewModel @Inject constructor() : ViewModel() {
    sealed interface UIState {
        object Loading : UIState
        data class ShowingLocationOnMap(
            val latitude: String,
            val longitude: String,
        ) : UIState
        data class ErrorOccurred(val message: String) : UIState
    }
}