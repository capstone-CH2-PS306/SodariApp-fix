package com.wahyu.sodariapp.Waste

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahyu.sodariapp.api.ApiConfig
import com.wahyu.sodariapp.api.response.DataItem
import com.wahyu.sodariapp.api.response.WasteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WasteInformationViewModel : ViewModel() {

    private val _listWaste = MutableLiveData<List<DataItem>>()

    val listWaste: MutableLiveData<List<DataItem>> = _listWaste


    init {
        getWaste()

    }

    private fun getWaste() {
        val call = ApiConfig.getApiService().getListWaste()
        call.enqueue(object : Callback<WasteResponse> {
            override fun onResponse(call: Call<WasteResponse>, response: Response<WasteResponse>) {
                if (response.isSuccessful) {
                    val dogsResponse = response.body()
                    val dogsItems = dogsResponse?.data
                    _listWaste.value = dogsItems as List<DataItem>

                }
            }

            override fun onFailure(call: Call<WasteResponse>, t: Throwable)
            {
            }
        })
    }

}