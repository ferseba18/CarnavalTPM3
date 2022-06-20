package com.example.carnaval.modelo

class TicketProvider {

    companion object {

        private lateinit var getTicket: TicketModel

        fun getTicketForCode(code: String): TicketModel {

            for (ticket in listTickets) {
                if (ticket.code.lowercase() == code.lowercase()) {
                    getTicket = ticket
                }
            }
            return getTicket
        }

        fun existCode(code: String): Boolean {

            var exist = false

            for (ticket in listTickets) {
                if (ticket.code.lowercase() == code.lowercase()) {
                    exist = true
                }
            }
            return exist


        }

        private val listTickets = listOf<TicketModel>(

            TicketModel("Golden", "Beneficios de Ticket Golden", 3000),
            TicketModel("Silver", "Beneficios de Ticket Silver", 2000),
            TicketModel("Bronze", "Beneficios de Ticket Bronze", 1000)

        )

    }
}