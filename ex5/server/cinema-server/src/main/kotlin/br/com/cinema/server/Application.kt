package br.com.cinema.server

import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.adapter.Server
import br.com.cinema.server.dataprovider.MovieTheaterRepositoryImpl
import br.com.cinema.server.tcp.ServerTcp
import br.com.cinema.server.udp.ServerUdp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val movieTheaterRepository: MovieTheaterRepository = MovieTheaterRepositoryImpl()
    val serverTcp: Server = ServerTcp(movieTheaterRepository = movieTheaterRepository)
    val serverUdp: Server = ServerUdp(movieTheaterRepository = movieTheaterRepository)

    launch(Dispatchers.Default) { serverTcp.run() }
    launch(Dispatchers.Default) { serverUdp.run() }

    println("Servers listening on port 4445 and 4446...")
}