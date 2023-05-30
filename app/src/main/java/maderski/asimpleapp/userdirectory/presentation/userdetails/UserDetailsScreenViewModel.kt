package maderski.asimpleapp.userdirectory.presentation.userdetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsScreenViewModel @Inject constructor() : ViewModel() {
    sealed interface UIState {
        object Loading : UIState
        data class ShowingUserDetails(
            val userName: String,
            val name: String,
            val phone: String,
            val email: String,
            val address: String,
            val website: String,
            val businessName: String,
            val businessCatchPhrase: String,
            val businessStrategy: String,
            val imageUrl: String?,
            val onViewLocationClick: () -> Unit,
        ) : UIState
        data class ErrorOccurred(val message: String) : UIState
    }
}