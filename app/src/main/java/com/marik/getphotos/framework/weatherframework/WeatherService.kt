package com.marik.getphotos.framework.weatherframework

import com.marik.getphotos.core.model.Weather
import retrofit2.http.GET

interface
WeatherService {
    @GET("data/2.5/weather?id=498817&appid=c35880b49ff95391b3a6d0edd0c722eb&lang=ru&units=metric")
    suspend fun getWeather(): Weather
}