package br.com.cinema.server.messaging

import br.com.cinema.server.messaging.KafkaExtension.sendAsync
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class KafkaProducer(
    private val properties: Properties = Properties()
) {
    fun setup() {
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
    }

    suspend fun send(topicName: String, key: String, message: String) {
        try {
            val producer = KafkaProducer<String, String>(properties)
            val record = ProducerRecord(topicName, key, message)

            producer.sendAsync(record).await()

        } catch (ex: Exception) {
            println(ex.message)
        }
    }
}