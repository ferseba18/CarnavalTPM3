package com.example.carnaval.actividades


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carnaval.databinding.ActivityActividadInicialBinding
import com.example.carnaval.modelo.PuntoModel
import com.example.carnaval.modelo.PuntoProvider
import com.example.carnaval.modelo.TicketProvider

class ActividadInicial : AppCompatActivity() {


    private lateinit var binding:ActivityActividadInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.Ingresar.setOnClickListener { cargarBeneficiosDeEntrada() }


    }

    private fun cargarBeneficiosDeEntrada() {

        val codigo = binding.Codigo.text.toString().lowercase()

        if (codigo.isEmpty()){
            Toast.makeText(this, "Ingrese el codigo de su entrada", Toast.LENGTH_SHORT).show()
            return
        }

        if (TicketProvider.existCode(codigo)){

            val ticket = TicketProvider.getTicketForCode(codigo)

            PuntoProvider.addPuntosTickets(ticket)

            Toast.makeText(this, "Sus beneficios han sido cargado correctamente", Toast.LENGTH_SHORT).show()
            verMenuPrincipal()
            return

        }


        Toast.makeText(this, "El codigo es incorrecto", Toast.LENGTH_SHORT).show()
        return





    }

    private fun verMenuPrincipal() {
        val intent = Intent(this, MenuPrincipalActivity::class.java)
        intent.putExtra("codigo verificado","correcto")
        startActivity(intent)
    }
    }
