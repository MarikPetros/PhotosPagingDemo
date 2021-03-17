package com.marik.getphotos.di

import com.marik.getphotos.core.data.IRemotePhotoSource
import com.marik.getphotos.core.data.PhotosRepository
import com.marik.getphotos.core.domain.GetPhotos
import com.marik.getphotos.framework.photoframework.PhotoService
import com.marik.getphotos.framework.photoframework.RemotePhotoSource
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createPhotosRetrofitClient() =
    retrofitClient(baseUrl)

val networkPhotoModule = module {
    single { createPhotosRetrofitClient().create(PhotoService::class.java) }
    single { RemotePhotoSource(get()) } bind IRemotePhotoSource::class
    single { PhotosRepository(get()) }
    single { GetPhotos(get()) }
}

private const val baseUrl = "https://picsum.photos/"


private fun retrofitClient(baseUrl: String): Retrofit =
    Retrofit.Builder().run {
        baseUrl(baseUrl)
        addConverterFactory(GsonConverterFactory.create())
        build()
    }

