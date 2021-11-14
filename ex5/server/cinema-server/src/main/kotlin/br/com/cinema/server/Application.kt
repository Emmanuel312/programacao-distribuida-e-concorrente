package br.com.cinema.server

import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.dataprovider.MovieTheaterRepositoryImpl
import br.com.cinema.server.udp.ServerUdp

fun main() {
    val movieTheaterRepository : MovieTheaterRepository = MovieTheaterRepositoryImpl()
    val serverUdp = ServerUdp(movieTheaterRepository = movieTheaterRepository)
    serverUdp.run()
}