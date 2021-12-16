package br.com.cinema.server

import br.com.cinema.server.dataprovider.MovieTheaterRepositoryImpl
import br.com.cinema.server.messaging.KafkaProducer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(): Unit = runBlocking {
    val movieTheaterRepository = MovieTheaterRepositoryImpl()
    val producer = KafkaProducer()

    producer.setup()

    withContext(Dispatchers.IO) {
        for (i in 1..10) {
            launch {
                producer.send("cinema-response", i.toString(), "ok")
            }
        }
    }
}
