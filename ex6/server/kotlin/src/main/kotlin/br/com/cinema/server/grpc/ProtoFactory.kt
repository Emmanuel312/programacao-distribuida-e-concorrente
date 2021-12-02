package br.com.cinema.server.grpc

import br.com.cinema.server.AvailableChairReply
import br.com.cinema.server.Chair

object ProtoFactory {
    fun availableChairReplyFactory(message: String): AvailableChairReply = AvailableChairReply.newBuilder()
        .setChairReply(message)
        .build()

    fun chairFactory(number: Long, available: Boolean): Chair = Chair.newBuilder()
        .setNumber(number)
        .setAvailable(available).build()
}