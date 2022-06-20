package com.example.carnaval.actividades

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.carnaval.databinding.ActivityActividadLectorQrBinding
import com.example.carnaval.modelo.PuntoModel
import com.example.carnaval.modelo.PuntoProvider
import com.example.carnaval.modelo.StandProvider
import com.google.zxing.integration.android.IntentIntegrator

class ActividadLectorQR : AppCompatActivity() {

    private lateinit var binding: ActivityActividadLectorQrBinding

    val PUNTOS_TRANSACCION = 1111
    val INTENTOS_TRANSACCION = 2222
    val DESCRIPCION_iNTENTO = "Compra de Intentos"
    val DESCRIPCION_PUNTOS = "Compra de Puntos"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadLectorQrBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initScanner()

    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        integrator.setPrompt("Realiza tu compra")
        integrator.setTorchEnabled(false)
        integrator.setBeepEnabled(false)
        integrator.initiateScan()
    }

    private fun transaccion(tipoDeTransaccion: Int, valor: Int) {

        if (valor == 0) {
            Toast.makeText(this, "No se puede realizar esta operacion!", Toast.LENGTH_LONG).show()
            menuPrincipal()
        }

        when (tipoDeTransaccion) {
            PUNTOS_TRANSACCION -> {
                comprarPuntos(valor)
                Toast.makeText(this, "Su Compra ha sido Exitosa", Toast.LENGTH_LONG).show()
                menuPrincipal()
            }
            INTENTOS_TRANSACCION -> {
                if (!sePuedeRealizaeLaOperacion(valor)) {
                    Toast.makeText(this, "No se puede realizar esta operacion!", Toast.LENGTH_LONG)
                        .show()
                    menuPrincipal()
                    return
                }
                comprarIntentos(valor)
                Toast.makeText(this, "Su Compra ha sido Exitosa", Toast.LENGTH_LONG).show()
                menuPrincipal()
            }
            else -> {
                Toast.makeText(this, "No se puede realizar esta operacion!", Toast.LENGTH_LONG)
                    .show()
                menuPrincipal()
            }
        }
    }

    private fun sePuedeRealizaeLaOperacion(valor: Int): Boolean {

        val cantidadTotalDePuntos = PuntoProvider.cantidadTotalDePuntos()
        var confirmacion:Boolean =false

        if (PuntoProvider.listaDePuntos.isNotEmpty()){

            if (cantidadTotalDePuntos >= valor) {
                confirmacion=true
            }
        }

        return confirmacion
    }

    private fun comprarIntentos(valor: Int) {
        var puntos = valor * -1
        PuntoProvider.listaDePuntos.add(PuntoModel(puntos, DESCRIPCION_iNTENTO))
    }

    private fun comprarPuntos(valor: Int) {
        PuntoProvider.listaDePuntos.add(PuntoModel(valor, DESCRIPCION_PUNTOS))
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_LONG).show()
                menuPrincipal()
            } else {

                val nameTransaction = result.contents.toString()

                Toast.makeText(this, nameTransaction, Toast.LENGTH_LONG)
                    .show()
                renderTransaction(nameTransaction)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun renderTransaction(nameTransaction: String) {

        val standModel = StandProvider.getStandForName(nameTransaction)

        if(nameTransaction.lowercase() == "juegos" ){
            binding.description.text = standModel.description
            binding.name.text = standModel.name
            binding.image.setImageResource(standModel.image)
            binding.priceEditable.isVisible = true
            binding.price.isVisible = false
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