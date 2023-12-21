package com.wahyu.sodariapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wahyu.sodariapp.DetailWasteIActivity
import com.wahyu.sodariapp.R
import com.wahyu.sodariapp.api.response.DataItem
import com.wahyu.sodariapp.databinding.WasteListBinding

class WasteAdapter(private val listWaste: List<DataItem>) :
    RecyclerView.Adapter<WasteAdapter.ViewHolder>() {

    class ViewHolder(var binding: WasteListBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WasteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val waste = listWaste[position]

        holder.apply {
            binding.apply {
                tvWaste.text =waste.name
                Glide.with(itemView.context)
                    .load(waste.image)
                    .error(R.drawable.bg_icon)
                    .into(ivWaste)


                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailWasteIActivity::class.java)
                    intent.putExtra(DetailWasteIActivity.EXTRA_WASTE, waste.image)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
    override fun getItemCount(): Int = listWaste.size

}
