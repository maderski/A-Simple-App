package maderski.asimpleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _isAppStarting = MutableStateFlow(true)
    val isAppStarting = _isAppStarting.asStateFlow()

    init {
        viewModelScope.launch {
            /*
                The splash screen will show until the value of isAppStaring is false, so tasks
                or setup of things that doesn't take too long can be done here.  Showing the
                splashscreen for a long period of time is not a good user experience.
             */
            _isAppStarting.value = false
        }
    }
}