package br.com.cinema.server.dataprovider

import br.com.cinema.server.adapter.MovieTheaterRepository

class MovieTheaterRepositoryImpl(
    private var chairs: List<Chair> = List(10) { Chair(number = it + 1, available = true) }
) : MovieTheaterRepository {

    override fun listAvailableChairs() = chairs.filter { it.available }

    override fun buyTicket(number: Int) : String {
        chairs.find { it.number == number }?.let { it ->
            if (!it.available) throw Exception("Chair not available!")

            chairs = chairs.map { chair ->
                if (number == chair.number) {
                    chair.copy(available = false)
                } else
                    chair
            }

            return "Success, Chair ${it.number} bought!"
        } ?: throw Exception("Chair not found!")
    }
}