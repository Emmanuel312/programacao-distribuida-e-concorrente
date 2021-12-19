package br.com.cinema.server.messaging

import java.time.Duration
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.flow
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata

object KafkaExtension {
    fun <K, V> KafkaProducer<K, V>.sendAsync(record: ProducerRecord<K, V>): Deferred<RecordMetadata> =
        CompletableDeferred<RecordMetadata>().apply {
            send(record) { metadata, exception ->
                if (exception != null) {
                    completeExceptionally(exception)
                } else {
                    complete(metadata)
                }
            }
        }

    fun <K, V> KafkaConsumer<K, V>.asFlow(timeout: Duration = Duration.ofMillis(500)) = flow {
        poll(timeout).forEach { emit(it) }
    }
}