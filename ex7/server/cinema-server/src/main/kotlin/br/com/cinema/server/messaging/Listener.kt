package br.com.cinema.server.messaging

interface Listener {
    suspend fun process(correlationId: String, message: String)
}
