package com.example.carnaval.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityActividadLectorQrBinding
import com.google.zxing.integration.android.IntentIntegrator

class ActividadLectorQR : AppCompatActivity() {

    private lateinit var binding: ActivityActividadLectorQrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadLectorQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initScanner()
    }

    private fun initScanner() {
        IntentIntegrator(this).initiateScan()
    }
}