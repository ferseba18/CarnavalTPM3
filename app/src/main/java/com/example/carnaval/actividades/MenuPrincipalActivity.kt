package com.example.carnaval.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carnaval.R
import com.example.carnaval.adaptadores.AdapterCategory
import com.example.carnaval.databinding.ActivityMenuPrincipalBinding
import com.example.carnaval.modelo.StandCategoryProvider
import kotlin.text.isEmpty as textIsEmpty

class MenuPrincipalActivity : AppCompatActivity() {

    private lateinit var bindingMenu: ActivityMenuPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMenu = ActivityMenuPrincipalBinding.inflate(layoutInflater)
        setContentView(bindingMenu.root)


        initRecyclerView()

        setListener()
    }

    private fun initRecyclerView() {
        val recyclerView = bindingMenu.listadoDeCategorias
        recyclerView.layoutManager =LinearLayoutManager(this)
        recyclerView.adapter = AdapterCategory(StandCategoryProvider.categorias)
    }


    private fun setListener() {

        val navigationBottom = bindingMenu.bottomNavigation
        navigationBottom.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    transaction()
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
                R.id.camara-> {
                    camara()
                    true
                }

                else -> {
                    super.onOptionsItemSelected(item)
                }
            }

        }


    }

    private fun location(){
        val location = Intent(this,ActividadUbicacion::class.java)
        startActivity(location)
    }

    private fun qr(){
        val qr = Intent (this, ActividadLectorQR::class.java)
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

    private fun camara(){
        val camara = Intent (this, ActividadCamara::class.java)
        startActivity(camara)
    }
    private fun stands(){
        val stands = Intent (this, ActividadStand::class.java)
        startActivity(stands)
    }
    private fun transaction(){
        val transaction = Intent (this, TransactionActivity::class.java)
        startActivity(transaction)
    }

    private fun validacionDeEntrada(){
        val inicial = Intent (this, ActividadInicial::class.java)
        startActivity(inicial)
    }

}