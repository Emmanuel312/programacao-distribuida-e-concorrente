package br.com.cinema.server.dataprovider

import br.com.cinema.server.adapter.MovieTheaterRepository

class MovieTheaterRepositoryImpl(private var chairs: List<Chair> = List(100) { Chair(number = it + 1) }) :
    MovieTheaterRepository {

    override fun listAvailableChairs() = chairs.filter { it.available }

    override fun buyTicket(number: Int) {
        chairs.find { it.number == number }?.let { it ->
            if (!it.available) throw Exception("Chair not available!")

            chairs = chairs.map { chair ->
                if (number == chair.number) {
                    chair.copy(available = false)
                } else
                    chair
            }

        } ?: throw Exception("Chair not found!")
    }
}