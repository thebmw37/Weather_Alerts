package com.example.weatheralerts.userInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

            val alertItems = mutableListOf<AlertItem>()

            for (i in it.features) {
                val alertItem = AlertItem(i.properties?.event, i.properties?.areaDesc, i.properties?.headline, i.properties?.description, i.properties?.instruction)
                alertItems.add(alertItem)
            }

            val alertRecyclerView: RecyclerView = findViewById(R.id.alertRecyclerView)
            alertRecyclerView.adapter = AlertAdapter(alertItems)
            alertRecyclerView.layoutManager = LinearLayoutManager(this)
        }

        viewModel.nwsData.observe(this, observer)
    }
}