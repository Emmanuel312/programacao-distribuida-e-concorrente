package br.com.cinema.server.tcp

import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.adapter.Server
import br.com.cinema.server.dto.Message
import br.com.cinema.server.dto.Op
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import kotlin.random.Random

class ServerTcp(
    private val socket: ServerSocket = ServerSocket(4446),
    private val movieTheaterRepository: MovieTheaterRepository
) : Server {

    override suspend fun run() = coroutineScope {
        while (true) {
            println("Waiting for connections...")
            val connection = socket.accept()

            println("Receiving connection...")
            launch(Dispatchers.IO) { process(connection) }

            if (movieTheaterRepository.listAvailableChairs().isEmpty()) socket.close()
        }
    }

    private suspend fun process(connection: Socket) {
        val input = BufferedReader(
            InputStreamReader(
                connection.getInputStream()
            )
        )
        val received = input.readLine()

        val message = Json.decodeFromString<Message>(received.toString())
        delay(Random.nextLong(100))

        when (message.op) {
            Op.List -> sendAvailableChairs(connection)
            Op.Buy -> sendBuyTicket(connection, message)
        }
    }

    private suspend fun sendAvailableChairs(connection: Socket) {
        val data = movieTheaterRepository.listAvailableChairs()
        println(data)
        println(Json.encodeToString(data.first()))
        sendMessage(connection, Json.encodeToString(data))
    }

    private suspend fun sendBuyTicket(connection: Socket, message: Message) {
        try {
            val successMessage = movieTheaterRepository.buyTicket(message.number!!)
            sendMessage(connection, successMessage)
        } catch (ex: Exception) {
            ex.message?.let { sendMessage(connection, it) }
        }
    }

    private suspend fun sendMessage(connection: Socket, data: String) {
        val output = DataOutputStream(
            connection.getOutputStream()
        )
        println("sending")
        withContext(Dispatchers.IO) {
            output.writeBytes(data)
            connection.close()
        }
    }
}