package br.com.cinema.server

import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.adapter.Server
import br.com.cinema.server.dataprovider.MovieTheaterRepositoryImpl
import br.com.cinema.server.tcp.ServerTcp
import br.com.cinema.server.udp.ServerUdp
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val movieTheaterRepository: MovieTheaterRepository = MovieTheaterRepositoryImpl()
    val server : Server = ServerTcp(movieTheaterRepository = movieTheaterRepository)
//    val server : Server = ServerUdp(movieTheaterRepository = movieTheaterRepository)
    server.run()
}