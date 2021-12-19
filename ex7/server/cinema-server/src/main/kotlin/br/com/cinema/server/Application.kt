package br.com.cinema.server

import br.com.cinema.server.dataprovider.Chair
import br.com.cinema.server.dataprovider.MovieTheaterRepositoryImpl
import br.com.cinema.server.messaging.KafkaConsumer
import br.com.cinema.server.messaging.KafkaProducer
import br.com.cinema.server.messaging.RequestListener
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val json = ObjectMapper().registerKotlinModule()
    val movieTheaterRepository = MovieTheaterRepositoryImpl()
    val producer = KafkaProducer<List<Chair>>("cinema-response", json)
    val requestListener = RequestListener(producer, movieTheaterRepository, json)
    val consumer = KafkaConsumer("cinema-request", requestListener)

    consumer.receive()


//    producer.send("123", movieTheaterRepository.listAvailableChairs())


}
