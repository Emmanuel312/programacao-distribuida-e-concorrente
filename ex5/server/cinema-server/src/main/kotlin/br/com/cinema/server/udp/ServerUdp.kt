package br.com.cinema.server.udp

import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.adapter.Server
import br.com.cinema.server.dto.Message
import br.com.cinema.server.dto.Op
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.DatagramPacket
import java.net.DatagramSocket
import kotlin.random.Random

class ServerUdp(
    private val socket: DatagramSocket = DatagramSocket(4445),
    private val buffer: ByteArray = ByteArray(1024),
    private val movieTheaterRepository: MovieTheaterRepository
) : Server {

    override suspend fun run() = coroutineScope {
        println("UDP - Server running on thread ${Thread.currentThread().name}")
        while (true) {
            println("UDP - Waiting for connections...")
            val packet = DatagramPacket(buffer, buffer.size)

            withContext(Dispatchers.IO) {
                socket.receive(packet)
                println("UDP - Receiving connection...")
                launch(Dispatchers.IO) { process(packet) }
            }

            if (movieTheaterRepository.listAvailableChairs().isEmpty()) socket.close()
        }
    }

    private suspend fun process(packet: DatagramPacket) {
        println("UDP - Request on thread ${Thread.currentThread().name}")
        val received = String(packet.data, Charsets.UTF_8).substring(0, packet.length)
        val message = Json.decodeFromString<Message>(received)

        delay(Random.nextLong(100))

        when (message.op) {
            Op.List -> sendAvailableChairs(packet)
            Op.Buy -> sendBuyTicket(packet, message)
        }
    }

    private suspend fun sendAvailableChairs(packet: DatagramPacket) {
        val data = movieTheaterRepository.listAvailableChairs()
        sendMessage(packet, Json.encodeToString(data))
    }

    private suspend fun sendBuyTicket(packet: DatagramPacket, message: Message) {
        try {
            val successMessage = movieTheaterRepository.buyTicket(message.number!!)
            sendMessage(packet, successMessage)
        } catch (ex: Exception) {
            ex.message?.let { sendMessage(packet, it) }
        }
    }

    private suspend fun sendMessage(clientPacket: DatagramPacket, data: String) {
        val address = clientPacket.address
        val port = clientPacket.port
        val packet = data.toByteArray()

        println("Sending...")
        withContext(Dispatchers.IO) {
            socket.send(DatagramPacket(packet, packet.size, address, port))
        }
    }
}