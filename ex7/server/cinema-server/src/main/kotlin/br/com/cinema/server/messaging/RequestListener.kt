package br.com.cinema.server.messaging

import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.dataprovider.Chair
import br.com.cinema.server.dto.Message
import br.com.cinema.server.dto.Op
import com.fasterxml.jackson.databind.ObjectMapper

class RequestListener(
    private val kafkaProducer: KafkaProducer<List<Chair>>,
    private val movieTheaterRepository: MovieTheaterRepository,
    private val json: ObjectMapper
) : Listener {

    override suspend fun process(correlationId: String, message: String) {
        val msg = json.readValue(message, Message::class.java)

        when (msg.op) {
            Op.List -> listAvailableChairs(correlationId)
            Op.Buy -> buyTicket(correlationId, msg.number)
        }
    }

    private suspend fun listAvailableChairs(correlationId: String) {
        kafkaProducer.send(correlationId, movieTheaterRepository.listAvailableChairs())
    }

    private fun buyTicket(correlationId: String, number: Int?) {
        number?.let {
            try {
                println(movieTheaterRepository.buyTicket(it))
            } catch (ex: Exception) {
                println(ex.message)
            }

        }
    }
}