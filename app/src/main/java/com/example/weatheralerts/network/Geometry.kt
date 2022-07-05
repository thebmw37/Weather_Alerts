package com.example.weatheralerts.network

data class Geometry(
    val type: String,
    val coordinates: List<List<List<Float>>>?
)
