package com.marik.getphotos.framework.weatherframework

import com.marik.getphotos.core.model.Weather

class RemoteWeatherSource(private val weatherService: WeatherService) {
    suspend fun getWeather(): Weather =
        weatherService.getWeather()
}