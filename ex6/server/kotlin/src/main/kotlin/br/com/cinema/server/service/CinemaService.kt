package br.com.cinema.server.service

import br.com.cinema.server.*
import br.com.cinema.server.adapter.MovieTheaterRepository

class CinemaService(
    private val repository: MovieTheaterRepository
) : CinemaGrpcKt.CinemaCoroutineImplBase() {
    @Override
    override suspend fun buyTicket(request: BuyTicketRequest): AvailableChairReply {
        return repository.buyTicket(request.ticket)
    }

    @Override
    override suspend fun listAllAvailableChairs(request: Empty): ChairList {
        return repository.listAvailableChairs()
    }
}