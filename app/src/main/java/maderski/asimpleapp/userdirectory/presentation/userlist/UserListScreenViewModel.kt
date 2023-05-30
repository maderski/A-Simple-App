package maderski.asimpleapp.userdirectory.presentation.userlist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserListScreenViewModel @Inject constructor() : ViewModel() {
    sealed interface UIState {
        object Loading : UIState
        data class ShowingUserList(
            val id: Int,
            val name: String,
            val email: String,
            val imageUrl: String?,
            val onClick: (id: Int) -> Unit,
        ) : UIState
        data class ErrorOccurred(
            val message: String,
        ) : UIState
    }
}