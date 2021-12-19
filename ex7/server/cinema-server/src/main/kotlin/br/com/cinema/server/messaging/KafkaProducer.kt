package br.com.cinema.server.messaging

import br.com.cinema.server.messaging.KafkaExtension.sendAsync
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class KafkaProducer<T>(
    private val topic: String,
    private val json: ObjectMapper
) {
    private val producer = KafkaProducer<String, String>(setup())

    suspend fun send(key: String, message: T): Unit = withContext(Dispatchers.IO) {
        try {
            launch {
                val record = ProducerRecord(topic, key, json.writeValueAsString(message))
                println(record)
                producer.sendAsync(record).await()
                println("done")
            }


        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    private fun setup(): Properties {
        val properties = Properties()

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)

        return properties
    }
}