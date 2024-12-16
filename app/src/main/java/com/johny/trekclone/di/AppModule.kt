package com.johny.trekclone.di

import com.johny.trekclone.MainViewModel
import com.johny.trekclone.core.data.AndroidConnectivityObserver
import com.johny.trekclone.core.data.networking.HttpClientFactory
import com.johny.trekclone.core.domain.ConnectivityObserver
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::AndroidConnectivityObserver).bind<ConnectivityObserver>()
    viewModelOf(::MainViewModel)
}