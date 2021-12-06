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
    val movieTheaterRepository = MovieTheaterRepositoryImpl()
    if(System.getenv("IS_UDP_SERVER").toBoolean()) startUdpServer(movieTheaterRepository)
    else startTcpServer(movieTheaterRepository)
}

suspend fun startTcpServer(movieTheaterRepository : MovieTheaterRepository) = runBlocking {
    val serverTcp: Server = ServerTcp(movieTheaterRepository = movieTheaterRepository)
    launch(Dispatchers.Default) { serverTcp.run() }
    println("Servers listening on port 4446...")
}

suspend fun startUdpServer(movieTheaterRepository : MovieTheaterRepository) = runBlocking {
    val serverUdp: Server = ServerUdp(movieTheaterRepository = movieTheaterRepository)
    launch(Dispatchers.Default) { serverUdp.run() }
    println("Servers listening on port 4445...")
}