package com.marik.getphotos.di

import com.marik.getphotos.ui.login.LoginViewModel
import com.marik.getphotos.ui.photos.PhotosViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::PhotosViewModel)
    viewModelOf(::LoginViewModel)
}