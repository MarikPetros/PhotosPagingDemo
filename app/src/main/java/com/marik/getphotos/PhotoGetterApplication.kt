package com.marik.getphotos

import android.app.Application
import com.marik.getphotos.di.networkPhotoModule
import com.marik.getphotos.di.networkWeatherModule
import com.marik.getphotos.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PhotoGetterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PhotoGetterApplication)
            modules(
                listOf(
                    networkPhotoModule,
                    networkWeatherModule,
                    viewModelModule
                )
            )
        }
    }
}