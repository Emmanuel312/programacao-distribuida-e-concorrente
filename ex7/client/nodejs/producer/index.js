async function publish(kafka, topic, key, value) {
    const producer = kafka.producer()

    await producer.connect()

    await producer.send({
        topic,
        messages: [
          { key, value },
        ],
        acks: 0 
    })

    await producer.disconnect()
}

module.exports = { publish }