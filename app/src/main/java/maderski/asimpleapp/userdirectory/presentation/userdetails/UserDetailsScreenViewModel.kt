package maderski.asimpleapp.userdirectory.presentation.userdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import maderski.asimpleapp.navigation.NavigationEvent
import maderski.asimpleapp.userdirectory.data.repository.UserRepository
import maderski.asimpleapp.userdirectory.presentation.userdetails.mappers.UserModelToUserDetailsDataMapper
import maderski.asimpleapp.userdirectory.presentation.userdetails.models.UserDetailsData
import maderski.asimpleapp.userdirectory.presentation.userdetails.models.ViewLocationClickedData
import javax.inject.Inject

@HiltViewModel
class UserDetailsScreenViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val userDetailsDataMapper: UserModelToUserDetailsDataMapper,
) : ViewModel() {
    sealed interface UIState {
        object Loading : UIState
        data class ShowingUserDetails(
            val userDetailsData: UserDetailsData
        ) : UIState

        data class ErrorOccurred(
            val message: String
        ) : UIState
    }

    val navEvent = MutableStateFlow<NavigationEvent?>(null)

    val screenState: StateFlow<UIState>
        get() = _screenState
    private val _screenState = MutableStateFlow<UIState>(UIState.Loading)

    fun init(userId: String?) {
        viewModelScope.launch {
            val id = userId?.toIntOrNull()
            if (id != null) {
                val result = userRepository.getUser(id)
                result.onSuccess { userModel ->
                    _screenState.value = UIState.ShowingUserDetails(
                        userDetailsData = userDetailsDataMapper(userModel, ::onViewLocationClick)
                    )
                }.onFailure {
                    showErrorScreen(it.message)
                }
            } else {
                showErrorScreen("User ID cannot be Null!")
            }
        }
    }

    private fun onViewLocationClick(data: ViewLocationClickedData) {
        with (data) {
            if (latitude != null && longitude != null) {
                navEvent.value = NavigationEvent.ToUserMapLocation(
                    userId = userId,
                    companyName = companyName,
                    latitude = latitude,
                    longitude = longitude,
                )
            } else {
                showErrorScreen(
                    "Latitude and/or Longitude cannot be Null! Lat: $latitude Lng: $longitude"
                )
            }
        }
    }

    private fun showErrorScreen(message: String?) {
        _screenState.value = UIState.ErrorOccurred(message = message ?: "Error Occurred!")
    }
}