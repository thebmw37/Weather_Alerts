package com.example.weatheralerts.userInterface

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatheralerts.network.nwsApi
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONObject

enum class NwsApiStatus { LOADING, ERROR, DONE }

class MainViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<NwsApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<NwsApiStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _nwsData = MutableLiveData<ResponseBody>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val nwsData: LiveData<ResponseBody> = _nwsData

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