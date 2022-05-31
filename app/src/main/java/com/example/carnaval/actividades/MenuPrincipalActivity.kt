package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carnaval.R
import com.example.carnaval.databinding.ActivityMenuPrincipalBinding

class MenuPrincipalActivity : AppCompatActivity() {
    private lateinit var bindingMenu: ActivityMenuPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMenu = ActivityMenuPrincipalBinding.inflate(layoutInflater)
        setContentView(bindingMenu.root)

        setListener()
    }

    private fun setListener() {

        val navigationBottom = bindingMenu.bottomNavigation
        navigationBottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    true
                }
                R.id.ubicacion -> {
                    location()
                    true
                }

                R.id.QR-> {
                    qr()
                    true
                }

                R.id.premios-> {
                    premios()
                    true
                }

                else -> {
                    super.onOptionsItemSelected(item)
                }
            }

        }

        bindingMenu.Eventos.setOnClickListener { evento() }
        bindingMenu.STANDS.setOnClickListener { stands() }
        bindingMenu.gastronomia.setOnClickListener { gastronomia() }
    }

    private fun location(){
        val location = Intent(this,ActividadUbicacion::class.java)
        startActivity(location)
    }

    private fun qr(){
        val qr = Intent (this, LectorQrAcivity::class.java)
        startActivity(qr)
    }

    private fun premios(){
        val premios = Intent (this, activity_premios::class.java)
        startActivity(premios)
    }

    private fun evento(){
        val evento = Intent (this, ActividadEvento::class.java)
        startActivity(evento)
    }

    private fun gastronomia(){
        val food = Intent (this, GastronomiaActivity::class.java)
        startActivity(food)
    }

    private fun stands(){
        val stands = Intent (this, ActividadStand::class.java)
        startActivity(stands)
    }
}