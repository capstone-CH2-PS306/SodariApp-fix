package com.wahyu.sodariapp.Waste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.wahyu.sodariapp.R
import com.wahyu.sodariapp.adapter.WasteAdapter
import com.wahyu.sodariapp.api.response.DataItem
import com.wahyu.sodariapp.databinding.ActivityWasteInformationBinding

class WasteInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWasteInformationBinding
    private val wasteInformationViewModel by viewModels<WasteInformationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWasteInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = GridLayoutManager(this, 2)
        binding.rvWaste.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvWaste.addItemDecoration(itemDecoration)

        wasteInformationViewModel.listWaste.observe(this) { items ->
            binding.rvWaste.adapter = showRecyclerView(items)
        }
    }

    private fun showRecyclerView(list: List<DataItem>): WasteAdapter {
        val wasteList = ArrayList<DataItem>()
        list?.let {
            wasteList.addAll(it)
        }

        return WasteAdapter(wasteList)
    }
}


