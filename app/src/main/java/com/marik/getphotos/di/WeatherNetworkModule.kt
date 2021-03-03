package com.marik.getphotos.di

import com.marik.getphotos.core.data.WeatherRepository
import com.marik.getphotos.core.domain.GetWeather
import com.marik.getphotos.framework.weatherframework.RemoteWeatherSource
import com.marik.getphotos.framework.weatherframework.WeatherService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createWeatherRetrofitClient() =
    retrofitClient(baseUrl)

val networkWeatherModule = module {
    single { createWeatherRetrofitClient().create(WeatherService::class.java) }
    single { RemoteWeatherSource(get()) }
    single { WeatherRepository(get()) }
    single { GetWeather(get()) }
}

private const val baseUrl = "https://api.openweathermap.org/"

private fun retrofitClient(baseUrl: String): Retrofit =
    Retrofit.Builder().run {
        baseUrl(baseUrl)
        addConverterFactory(GsonConverterFactory.create())
        build()
    }