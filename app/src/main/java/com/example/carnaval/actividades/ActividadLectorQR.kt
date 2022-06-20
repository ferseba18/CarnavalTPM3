package com.example.carnaval.actividades

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carnaval.databinding.ActivityActividadLectorQrBinding
import com.example.carnaval.modelo.PuntoProvider
import com.example.carnaval.modelo.StandProvider
import com.google.zxing.integration.android.IntentIntegrator

class ActividadLectorQR : AppCompatActivity() {

    private lateinit var binding: ActivityActividadLectorQrBinding

    val PUNTOS_TRANSACCION = "puntos"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadLectorQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initScanner()

        binding.btnComprar.setOnClickListener { realizarTransaccion() }

    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Realiza tu compra")
        integrator.setTorchEnabled(false)
        integrator.setBeepEnabled(false)
        integrator.initiateScan()
    }

    private fun realizarTransaccion() {

        var nameTransaction = binding.name.text.toString().lowercase()


        when (nameTransaction) {

            PUNTOS_TRANSACCION -> {
                var cantidadDePuntos = binding.priceEditable.text.toString()

                if (cantidadDePuntos.isEmpty()){
                    Toast.makeText(
                        this,
                        "Ingresa el valor",
                        Toast.LENGTH_LONG
                    ).show()
                    return
                }

                PuntoProvider.comprarPuntos(cantidadDePuntos.toInt())
                Toast.makeText(this, "Su Compra ha sido Exitosa", Toast.LENGTH_LONG).show()
                menuPrincipal()
                return
            }


            else -> {
                var puntos = binding.price.text.toString()
                var confirmacionDeCompra = PuntoProvider.sePuedeRealizaeLaOperacion(puntos.toInt())

                if (confirmacionDeCompra) {

                    PuntoProvider.comprarIntentos(puntos.toInt(), nameTransaction)
                    Toast.makeText(this, "Su Compra ha sido Exitosa", Toast.LENGTH_LONG).show()
                    menuPrincipal()
                    return
                } else {

                    Toast.makeText(
                        this,
                        "No requieres de los puntos suficientes",
                        Toast.LENGTH_LONG
                    ).show()
                    menuPrincipal()
                    return

                }


            }
        }
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show()
                menuPrincipal()
            } else {

                val nameTransaction = result.contents.toString()

                renderTransaction(nameTransaction)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun renderTransaction(nameTransaction: String) {

        val standModel = StandProvider.getStandForName(nameTransaction)

        if (nameTransaction.lowercase() == "puntos") {
            binding.description.text = standModel.description
            binding.name.text = standModel.name
            binding.image.setImageResource(standModel.image)
            binding.priceEditable.visibility = View.VISIBLE
            binding.price.visibility = View.GONE
            return
        }



        binding.description.text = standModel.description
        binding.name.text = standModel.name
        binding.image.setImageResource(standModel.image)
        binding.price.text = standModel.price.toString()


    }

    private fun menuPrincipal() {
        val menuPrincipal = Intent(this, MenuPrincipalActivity::class.java)
        startActivity(menuPrincipal)
    }


}