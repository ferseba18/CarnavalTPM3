package com.example.carnaval.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityTransactionBinding

class TransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}