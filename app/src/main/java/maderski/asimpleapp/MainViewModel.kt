package maderski.asimpleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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
            delay(5000)
            _isAppStarting.value = false
        }
    }
}