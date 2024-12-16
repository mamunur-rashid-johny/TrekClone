package com.johny.trekclone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johny.trekclone.core.domain.ConnectivityObserver
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    connectivityObserver: ConnectivityObserver
) : ViewModel() {

    val isConnected = connectivityObserver.isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            false
        )

    val isLoading = MutableStateFlow(true)

    init {
        viewModelScope.launch {
            delay(10000)
            isLoading.value = false
        }

    }

}