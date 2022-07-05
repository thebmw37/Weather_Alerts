package com.example.weatheralerts.userInterface

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatheralerts.network.WeatherAlert
import com.example.weatheralerts.network.nwsApi
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONObject

enum class NwsApiStatus { LOADING, ERROR, DONE }

class MainViewModel : ViewModel() {

    private val _status = MutableLiveData<NwsApiStatus>()

    val status: LiveData<NwsApiStatus> = _status

    private val _nwsData = MutableLiveData<WeatherAlert>()

    val nwsData: LiveData<WeatherAlert> = _nwsData

    fun getNwsData() {
        viewModelScope.launch {
            _status.value = NwsApiStatus.LOADING
            try {
                _nwsData.value = nwsApi.retrofitService.getData()
                _status.value = NwsApiStatus.DONE
            } catch (e: Exception) {
                println(e)
                _status.value = NwsApiStatus.ERROR
                _nwsData.value = null
            }
        }
    }
}