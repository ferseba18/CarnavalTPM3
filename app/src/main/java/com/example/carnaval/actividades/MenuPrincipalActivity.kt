package com.example.carnaval.actividades

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carnaval.R
import com.example.carnaval.adaptadores.AdapterCategory
import com.example.carnaval.databinding.ActivityMenuPrincipalBinding
import com.example.carnaval.modelo.StandCategoryModel
import com.example.carnaval.modelo.StandCategoryProvider

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
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterCategory(StandCategoryProvider.categorias) { standCategoryModel ->
                onItemSelect(standCategoryModel)
            }
    }

    private fun onItemSelect(standCategoryModel: StandCategoryModel) {
        stands(standCategoryModel.name)
        //Toast.makeText( this,standCategoryModel.name, Toast.LENGTH_SHORT).show()
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

                R.id.QR -> {
                    qr()
                    true
                }

                R.id.premios -> {
                    premios()
                    true
                }
                R.id.camara -> {
                    camara()
                    true
                }

                else -> {
                    super.onOptionsItemSelected(item)
                }
            }

        }


    }

    private fun location() {
        val location = Intent(this, ActividadUbicacion::class.java)
        startActivity(location)
    }

    private fun qr() {
        val qr = Intent(this, ActividadLectorQR::class.java)
        startActivity(qr)
    }

    private fun premios() {
        val premios = Intent(this, activity_premios::class.java)
        startActivity(premios)
    }


    private fun camara() {
        val camara = Intent(this, ActividadCamara::class.java)
        startActivity(camara)
    }

    private fun stands(category :String) {
        val stands = Intent(this, ActividadStand::class.java)
        stands.putExtra("category",category)
        startActivity(stands)
    }

    private fun transaction() {
        val transaction = Intent(this, TransactionActivity::class.java)
        startActivity(transaction)
    }



}