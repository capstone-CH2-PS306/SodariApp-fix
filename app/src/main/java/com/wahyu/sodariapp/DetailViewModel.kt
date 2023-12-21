package com.wahyu.sodariapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahyu.sodariapp.api.ApiConfig
import com.wahyu.sodariapp.api.response.WasteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private val _isLoadingDetail = MutableLiveData<Boolean>()
    val isLoadingDetail: LiveData<Boolean> = _isLoadingDetail

    private val _detailWaste = MutableLiveData<WasteResponse>()
    val detailWaste: LiveData<WasteResponse> = _detailWaste

    fun findWaste () {
        _isLoadingDetail.value = true
        val client = ApiConfig.getApiService().getListWaste()
        client.enqueue(object : Callback<WasteResponse> {
            override fun onResponse(
                call: Call<WasteResponse>,
                response: Response<WasteResponse>
            ) {
                _isLoadingDetail.value = false
                if(response.isSuccessful && response.body() != null) {
                    _detailWaste.value = response.body()
                }
            }

            override fun onFailure(call: Call<WasteResponse>, t: Throwable) {
                _isLoadingDetail.value = false
                t.message?.let { Log.d("failure", it) }
            }

        })
    }
}