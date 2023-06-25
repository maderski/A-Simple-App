package maderski.asimpleapp.userdirectory.presentation.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import maderski.asimpleapp.navigation.NavigationEvent
import maderski.asimpleapp.userdirectory.domain.repository.UserRepository
import maderski.asimpleapp.userdirectory.presentation.userlist.mappers.UserModelSetToUserCardDataMapper
import maderski.asimpleapp.userdirectory.presentation.userlist.models.UserCardData
import javax.inject.Inject

@HiltViewModel
class UserListScreenViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val userCardMapper: UserModelSetToUserCardDataMapper,
) : ViewModel() {
    sealed interface UIState {
        object Loading : UIState
        data class ShowingUserList(
            val cardListData: List<UserCardData>,
        ) : UIState
        data class ErrorOccurred(
            val message: String,
        ) : UIState
    }

    val navEvent = MutableStateFlow<NavigationEvent?>(null)

    val screenState: StateFlow<UIState>
        get() = _screenState
    private val _screenState = MutableStateFlow<UIState>(UIState.Loading)

    fun loadUsers() {
        viewModelScope.launch {
            getAllUsers()
        }
    }

    private suspend fun getAllUsers() {
        val result = userRepository.getAllUsers()
        result.onSuccess { allUsers ->
            _screenState.value = UIState.ShowingUserList(
                cardListData = userCardMapper(allUsers, ::selectUser)
            )
        }.onFailure {
            showErrorScreen(it.message)
        }
    }

    private fun selectUser(id: Int) {
        navEvent.value = NavigationEvent.ToUserDetails(id.toString())
    }

    private fun showErrorScreen(message: String?) {
        _screenState.value = UIState.ErrorOccurred(message = message ?: "Error Occurred!")
    }
}