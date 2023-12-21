package com.wahyu.sodariapp

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahyu.sodariapp.api.ApiConfig
import com.wahyu.sodariapp.api.response.WasteResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemListViewModel : ViewModel() {
    private val _listItemResponse = MutableLiveData<WasteResponse>()
    val listItemResponse: LiveData<WasteResponse> = _listItemResponse
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getListItem() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getListWaste()
        client.enqueue(object : Callback<WasteResponse> {
            override fun onResponse(
                call: Call<WasteResponse>,
                response: Response<WasteResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listItemResponse.value = response.body()
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<WasteResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(ContentValues.TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }
}