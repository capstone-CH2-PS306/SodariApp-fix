package com.wahyu.sodariapp.api.response

import com.google.gson.annotations.SerializedName

data class WasteResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("characteristics")
	val characteristics: String? = null,

	@field:SerializedName("impact-of waste-on-the-environment")
	val impactOfWasteOnTheEnvironment: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
