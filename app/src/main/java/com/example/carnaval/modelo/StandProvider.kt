package com.example.carnaval.modelo

import com.example.carnaval.R

class StandProvider {


    companion object {

        var listadoPorCategoria: MutableList<StandModel> = mutableListOf()
        lateinit var standForName: StandModel

        fun getStandForName(nameStand: String): StandModel {
            val nameStand = nameStand



            for (stand in listadoDeStands) {

                if (stand.name.lowercase() == nameStand.lowercase()) {
                    standForName = stand
                }
            }

            return standForName

        }

        fun listForCategory(category: String): MutableList<StandModel> {

            val category = category

            if (listadoPorCategoria.isNotEmpty()) {
                listadoPorCategoria.clear()
            }

            for (stand in listadoDeStands) {

                if (stand.category.lowercase() == category.lowercase()) {
                    listadoPorCategoria.add(stand)
                }
            }

            return listadoPorCategoria

        }


        val listadoDeStands = listOf<StandModel>(

            StandModel(
                "No Te Va Gustar",
                "La banda Uruuaya presentara su ultimo album Luz, con grandes artistas invitados",
                R.drawable.evento_ntvg,
                500,
                "Eventos",-34.664752334222754,
                -58.56843709945678
            ),
            StandModel(
                "Gabriel Rolon",
                "'Palabra plena', en cambio, nos desafía a pensar, a transitar el laberinto de nuestro propio enigma intentando evitar las trampas de la comodidad. Porque las cosas importantes de la vida son incómodas. Caminamos entre el amor y la pérdida, la felicidad y la angustia, la esperanza y el deseo.",
                R.drawable.evento_rolon,
                500,
                "Eventos",
                -34.665271957135786,
                -58.5703157992547
            ),
            StandModel(
                "Tacos",
                "El taco es una preparación culinaria muy popular de México que consiste en una tortilla, generalmente de maíz, que se dobla o se enrolla para contener dentro diversos ingredientes y algún tipo de salsa.",
                R.drawable.food_tacos,
                200,
                "Gastronomia",
                -34.66575576466635,
                -58.564816985838746
            ),
            StandModel(
                "Asado",
                "La carne asada es una tradición añeja proveniente de las grandes extensiones fértiles de la llanura pampeana. Pero el asado argentino es más que la comida típica; es todo un ritual.",
                R.drawable.food_asado,
                300,
                "Gastronomia",
                -34.66831585551236,
                -58.56131774093531
            ),
            StandModel(
                "Comida Vegana", "Una novedosa carta de comida vegana y productos sustentables",
                R.drawable.food_vegana,
                300,
                "Gastronomia",
                -34.667781137330685,
                -58.5631082636595
            ),
            StandModel(
                "Licuados", "Veni a disfrutar nuestros licuados echos con fruta organica",
                R.drawable.food_licuados,
                200,
                "Gastronomia",
                -34.667205482314564,
                -58.562986850738525
            ),
            StandModel(
                "Tiro al arco", "Proba tu destreza con el arco y llevate grandes premios",
                R.drawable.game_tiro_al_arco,
                200,
                "Juegos",
                -34.66865262913868,
                -58.56489658355712
            ),
            StandModel(
                "Tumba Latas",
                "La actividad consiste en lanzar el elemento hacia las latas que se encuentran ordenadas en pirámide, sin sobrepasar la marca establecida. - Cada jugador tendrá tres intentos de lanzamiento hacia las latas con la finalidad de derribarlas.",
                R.drawable.game_tumbas_latas,
                200,
                "Juegos",
                -34.66808365415518,
                -58.56700742226725

            ),
            StandModel(
                "Pesca",
                "Veni a probar tu destreza pescando y llevate el pez",
                R.drawable.game_pesca,
                200,
                "Juegos",
                -34.67009051571684,
                -58.56388991315839
            ),
            StandModel(
                "Ruleta",
                "Veni a Probar tu suerte y llevate el gran premio secreto",
                R.drawable.game_ruleta,
                200,
                "Juegos",
                -34.66908090059341,
                -58.56498058689645
            ),
            StandModel(
                "Puntos",
                "Kermes cashless es el sistema que te permite cargar dinero en tu aplicacion, adquirir productos gastronómicos y comprar merchandising en el festival.",
                R.drawable.puntos,
                0,
                "juegos",
                -34.67035170583668,
                -58.5628052
            )
        )
    }
}