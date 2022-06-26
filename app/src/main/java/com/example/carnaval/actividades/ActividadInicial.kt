package com.example.carnaval.actividades


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carnaval.databinding.ActivityActividadInicialBinding
import com.example.carnaval.modelo.PuntoProvider
import com.example.carnaval.modelo.TicketProvider

class ActividadInicial : AppCompatActivity() {


    private lateinit var binding: ActivityActividadInicialBinding
    private var beneficiosCargado :Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(beneficiosCargado){
           verMenuPrincipal()
        }

        //binding.Ingresar.setOnClickListener { cargarBeneficiosDeEntrada() }


    }

    private fun cargarBeneficiosDeEntrada() {



        if (codigoIngresasdo().isEmpty()) {
            Toast.makeText(this, "Ingrese el codigo de su entrada", Toast.LENGTH_SHORT).show()
            return
        }

        if (TicketProvider.existCode(codigoIngresasdo())) {

            val ticket = TicketProvider.getTicketForCode(codigoIngresasdo())

            PuntoProvider.addPuntosTickets(ticket)
            beneficiosCargado = true

            Toast.makeText(
                this,
                "Sus beneficios han sido cargado correctamente",
                Toast.LENGTH_SHORT
            ).show()
            verMenuPrincipal()


        }

        Toast.makeText(this, "El codigo es incorrecto", Toast.LENGTH_SHORT).show()
    }

    private fun codigoIngresasdo(): String {

        return binding.Codigo.text.toString().lowercase()
    }

    private fun verMenuPrincipal() {
        val intent = Intent(this, MenuPrincipalActivity::class.java)
        startActivity(intent)
    }
}
