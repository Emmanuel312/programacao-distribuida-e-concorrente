package br.com.cinema.server.dataprovider

import br.com.cinema.server.AvailableChairReply
import br.com.cinema.server.Chair
import br.com.cinema.server.ChairList
import br.com.cinema.server.adapter.MovieTheaterRepository
import br.com.cinema.server.grpc.ProtoFactory
import jakarta.inject.Singleton

@Singleton
class MovieTheaterRepositoryImpl(
    private var chairs: List<Chair> = List(10) {
        ProtoFactory.chairFactory((it + 1).toLong(), true)
    }
) : MovieTheaterRepository {

    override fun listAvailableChairs(): ChairList =
        try {
            val availableChairs = ChairList.newBuilder()
            chairs.filter { it.available }.forEachIndexed { index, chair ->
                availableChairs.addChairs(index, chair)
            }

            availableChairs.build()
        } catch (ex: Exception) {
            println(ex.message)
            ChairList.newBuilder().build()
        }

    override fun buyTicket(number: Long): AvailableChairReply {
        chairs.find { it.number == number }?.let {
            if (!it.available) return ProtoFactory.availableChairReplyFactory("Chair not available!")

            chairs = chairs.map { chair ->
                if (number == chair.number) {
                    Chair.newBuilder().setNumber(chair.number).setAvailable(false).build()
                } else
                    chair
            }

            return ProtoFactory.availableChairReplyFactory("Success, Chair ${it.number} bought!")
        } ?: run {
            return ProtoFactory.availableChairReplyFactory("Chair not found!")
        }
    }
}