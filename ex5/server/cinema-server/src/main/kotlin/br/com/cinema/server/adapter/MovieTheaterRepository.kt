package br.com.cinema.server.adapter

import br.com.cinema.server.dataprovider.Chair

interface MovieTheaterRepository {
    fun listAvailableChairs() : List<Chair>
    fun buyTicket(number: Int)
}