package com.example.carnaval.modelo

class PuntoProvider {


    companion object {

        fun cantidadTotalDePuntos(): Int {

            var cantidadTotalDePuntos = 0

            if (listaDePuntos.isNotEmpty()) {

                listaDePuntos.forEach {
                    cantidadTotalDePuntos += it.cantidad

                }
            }



            return cantidadTotalDePuntos

        }

        fun comprarIntentos(valor: Int,nameGame : String) {
            var puntos = valor * -1
            listaDePuntos.add(PuntoModel(puntos, "Compra de un intento", nameGame))
        }

        fun comprarPuntos(valor : Int){

            listaDePuntos.add(PuntoModel(valor,"Compra de Puntos","Puntos"))
        }

        fun addPuntosTickets(ticketModel: TicketModel){

            listaDePuntos.add(PuntoModel(ticketModel.valor,ticketModel.description,ticketModel.code))

        }
        fun addPuntosPremios(puntos:Int){

            listaDePuntos.add(PuntoModel(puntos,"Puntos ganados","Rueda Magica"))

        }

        fun sePuedeRealizaeLaOperacion(valor: Int): Boolean {

            val cantidadTotalDePuntos = cantidadTotalDePuntos()
            var confirmacion: Boolean = false


                if (cantidadTotalDePuntos >= valor) {
                    confirmacion = true
                }


            return confirmacion
        }

        var listaDePuntos: MutableList<PuntoModel> = mutableListOf()


    }
}