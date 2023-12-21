package com.wahyu.sodariapp.api

import com.wahyu.sodariapp.api.response.WasteResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("waste")
    fun getListWaste(): Call<WasteResponse>
}