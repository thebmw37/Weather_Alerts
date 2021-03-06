package com.example.weatheralerts.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.weather.gov/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface nwsApiService {
    @GET("alerts/active")
    suspend fun getData(@Query("area") stateIdentifier: String): WeatherAlert
}

object nwsApi {
    val retrofitService: nwsApiService by lazy { retrofit.create(nwsApiService::class.java) }
}