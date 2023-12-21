package com.wahyu.sodariapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wahyu.sodariapp.Waste.WasteInformationActivity
import com.wahyu.sodariapp.camera.CameraScanActivity

import com.wahyu.sodariapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainScan.setOnClickListener {
            val intent = Intent(this, CameraScanActivity::class.java)
            startActivity(intent)
        }

        binding.btnWasteInformation.setOnClickListener {
            val intent = Intent(this, WasteInformationActivity::class.java)
            startActivity(intent)
        }
    }
}
