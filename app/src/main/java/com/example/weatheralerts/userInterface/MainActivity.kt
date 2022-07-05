package com.example.weatheralerts.userInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.weatheralerts.R
import com.example.weatheralerts.network.WeatherAlert
import okhttp3.ResponseBody
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getNwsData()

        val observer = Observer<WeatherAlert> {
            println("------------------------------------------------------------------------------------------------------------------------------------------------------------")
            println(it.features[0].properties?.description)
            println("------------------------------------------------------------------------------------------------------------------------------------------------------------")
        }

        viewModel.nwsData.observe(this, observer)
    }
}