package com.marik.getphotos.core.data

import com.marik.getphotos.core.model.Weather
import com.marik.getphotos.framework.weatherframework.RemoteWeatherSource

class WeatherRepository (private val remoteWeatherSource: RemoteWeatherSource) {
    suspend fun getWeather(): Weather =
         remoteWeatherSource.getWeather()
}