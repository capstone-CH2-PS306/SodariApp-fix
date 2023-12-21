package com.wahyu.sodariapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.wahyu.sodariapp.api.response.DataItem
import com.wahyu.sodariapp.databinding.ActivityDetailWasteIactivityBinding

class DetailWasteIActivity : AppCompatActivity() {

    private val detailViewModel by viewModels<DetailViewModel>()
    private lateinit var binding: ActivityDetailWasteIactivityBinding

    companion object {
        const val EXTRA_WASTE = "extra_waste"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWasteIactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wasteName = intent.getStringExtra(EXTRA_WASTE)
        if (wasteName != null) {
            detailViewModel.findWaste()
        }

        detailViewModel.detailWaste.observe(this) { wasteResponse ->
            val wasteItem = wasteResponse.data?.firstOrNull()
            if (wasteItem != null) {
                setDataWaste(wasteItem)
            }
        }
        detailViewModel.isLoadingDetail.observe(this) {
            showLoading(it)
        }
    }



    private fun setDataWaste(wasteItem: DataItem) {
        binding.apply {
            Glide.with(applicationContext)
                .load(wasteItem.image)
                .error(R.drawable.bg_icon)
                .into(ivWaste)
            tvWasteName.text = wasteItem.name
            tvWasteCharacteristics.text = wasteItem.characteristics
            tvWasteImpact.text = wasteItem.impactOfWasteOnTheEnvironment
        }
    }
    private fun showLoading(isLoading: Boolean) {
        if(isLoading) {
            binding.progressbar.visibility = View.VISIBLE
        } else {
            binding.progressbar.visibility = View.INVISIBLE
        }
    }
}