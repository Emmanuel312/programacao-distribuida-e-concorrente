package br.com.cinema.server.udp

import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.adapter.Server
import br.com.cinema.server.dto.Message
import br.com.cinema.server.dto.Op
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.net.DatagramPacket
import java.net.DatagramSocket


class ServerUdp(
    private val socket: DatagramSocket = DatagramSocket(4445),
    private val buffer: ByteArray = ByteArray(1024),
    private val movieTheaterRepository : MovieTheaterRepository
) : Server {

    override fun run() {
        while (true) {
            val packet = DatagramPacket(buffer, buffer.size)
            println("Esperando por uma requisição")
            socket.receive(packet)
//            val address = packet.address
//            val port = packet.port
//            packet = DatagramPacket(buffer, buffer.size, address, port)
            val received = String(packet.data, Charsets.UTF_8).substring(0, packet.length)
            val message = Json.decodeFromString<Message>(received)
//            socket.send(packet)

            println(message)

            when(message.op) {
                Op.List -> movieTheaterRepository.listAvailableChairs()
                Op.Buy -> movieTheaterRepository.buyTicket(message.number!!)
            }
        }
        socket.close()
    }

}