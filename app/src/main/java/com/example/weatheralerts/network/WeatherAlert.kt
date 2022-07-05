package com.example.weatheralerts.network

import com.squareup.moshi.Json

data class WeatherAlert(
    @Json(name = "@context") val contextVal: Any,
    val type: String,
    val features: List<Feature>,
    val title: String,
    val updated: String
)