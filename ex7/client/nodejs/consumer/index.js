async function consume(kafka, groupId, topic, handler) {
    const consumer = kafka.consumer({ groupId })

    await consumer.connect()
    await consumer.subscribe({ topic, fromBeginning: false })
    
    await consumer.run({
      eachMessage: async ({ topic, partition, message }) => {
        const hasCorrelation = await handler(message.key.toString(), message.value.toString())
        console.log(hasCorrelation)
        if(hasCorrelation) consumer.disconnect()
      }
    })
}

module.exports = { consume }