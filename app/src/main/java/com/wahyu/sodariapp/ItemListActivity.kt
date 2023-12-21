package com.wahyu.sodariapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.wahyu.sodariapp.databinding.ActivityItemListBinding

class ItemListActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityItemListBinding
    private val binding get() = _binding

    private lateinit var itemListViewModel: ItemListViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jenis = intent.getStringExtra("jenis")
        binding.tvItemListResult.text = jenis

        itemListViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ItemListViewModel::class.java)

        val layoutManager = LinearLayoutManager(this)
        binding.rvItemListsResult.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvItemListsResult.addItemDecoration(itemDecoration)
    }

    private fun getListsItem(jenis: String) {
        itemListViewModel.getListItem()
        itemListViewModel.isLoading.observe(this) {
            showLoading(it)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBarItemLists.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}