package com.marik.getphotos.core.model

data class Weather(
    val coord: Coordinates,
    val weather: List<Weath>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)

class Sys(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

class Clouds(val all: Int)

class Wind(
    val speed: Int,
    val deg: Int,
)

class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int
)

class Weath(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

class Coordinates(
    val lon: Double,
    val lat: Double
)

