package br.com.cinema.server.grpc

import br.com.cinema.server.*
import br.com.cinema.server.adapter.MovieTheaterRepository

class CinemaOperationsService(
    private val repository: MovieTheaterRepository
) : CinemaGrpcKt.CinemaCoroutineImplBase() {
    override suspend fun buyTicket(request: BuyTicketRequest): AvailableChairReply {
        return repository.buyTicket(request.ticket)
    }

    override suspend fun listAllAvailableChairs(request: Empty): ChairList {
        return repository.listAvailableChairs()
    }
}