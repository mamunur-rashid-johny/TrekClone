package com.johny.trekclone

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johny.trekclone.core.domain.ConnectivityObserver
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    connectivityObserver: ConnectivityObserver
) : ViewModel() {

    val isConnected = connectivityObserver.isConnected
        .stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        true
        )

}