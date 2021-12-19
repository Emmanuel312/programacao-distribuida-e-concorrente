package br.com.cinema.server.messaging

import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import java.time.Duration
import java.util.*

class KafkaConsumer(
    topic: String,
    private val listener: Listener,
) {
    private var consumer: KafkaConsumer<String, String>

    init {
        consumer = KafkaConsumer<String, String>(setup())
        consumer.subscribe(listOf(topic))
    }

    suspend fun receive() = withContext(newSingleThreadContext("ReceiveThread")) {
        launch {
            while (true) {
                consumer.poll(Duration.ofMillis(10)).forEach {
                    listener.process(it.key().toString(), it.value())
                }
            }
        }
    }

    private fun setup(): Properties {
        val properties = Properties()
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "cinema-server-group")

        return properties
    }
}