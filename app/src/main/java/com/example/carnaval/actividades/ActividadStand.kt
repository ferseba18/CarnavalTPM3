package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carnaval.databinding.ActivityActividadStandBinding

class ActividadStand : AppCompatActivity() {

    private lateinit var bindingMenu: ActivityActividadStandBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMenu = ActivityActividadStandBinding.inflate(layoutInflater)

        setContentView(bindingMenu.root)


    }

}
