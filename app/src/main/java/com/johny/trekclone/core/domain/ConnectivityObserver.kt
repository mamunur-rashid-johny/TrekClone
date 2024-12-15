package com.johny.trekclone.core.domain

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    val isConnected:Flow<Boolean>
}