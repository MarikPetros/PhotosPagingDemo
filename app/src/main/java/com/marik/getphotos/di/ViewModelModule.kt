package com.marik.getphotos.di

import com.marik.getphotos.ui.login.LoginViewModel
import com.marik.getphotos.ui.photos.PhotosViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { PhotosViewModel(get()) }
    single { LoginViewModel(get()) }
}