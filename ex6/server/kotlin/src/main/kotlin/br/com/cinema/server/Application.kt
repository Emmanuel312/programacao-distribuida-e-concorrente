package br.com.cinema.server

import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.dataprovider.MovieTheaterRepositoryImpl
import br.com.cinema.server.grpc.Server
import br.com.cinema.server.service.CinemaService
import io.grpc.BindableService

fun main() {
    val movieTheaterRepository: MovieTheaterRepository = MovieTheaterRepositoryImpl()
    val cinemaService : BindableService = CinemaService(movieTheaterRepository)
    val grpcServer = Server(50051, mutableListOf(cinemaService))

    grpcServer.configure()
    grpcServer.start()
    grpcServer.blockUntilShutdown()
}