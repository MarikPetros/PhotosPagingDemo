package com.marik.getphotos.core.domain

import com.marik.getphotos.core.data.WeatherRepository
import com.marik.getphotos.core.model.Weather

class GetWeather(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(): Weather =
        weatherRepository.getWeather()
}