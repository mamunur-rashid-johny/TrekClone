package com.johny

import android.app.Application
import com.johny.trekclone.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TrekApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TrekApp)
            androidLogger()
            modules(appModule)
        }
    }
}