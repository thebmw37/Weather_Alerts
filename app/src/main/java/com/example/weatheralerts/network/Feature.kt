package com.example.weatheralerts.network

data class Feature(
    val id: String,
    val type: String,
    val geometry: Geometry?,
    val properties: Properties?
)
