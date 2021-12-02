package br.com.cinema.server.adapter

import br.com.cinema.server.AvailableChairReply
import br.com.cinema.server.ChairList

interface MovieTheaterRepository {
    fun listAvailableChairs(): ChairList
    fun buyTicket(number: Long): AvailableChairReply
}