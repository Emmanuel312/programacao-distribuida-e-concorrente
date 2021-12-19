const fs = require("fs/promises");
const { exit } = require("process");
const { Kafka } = require('kafkajs');
const { randomUUID } = require("crypto");

const kafka = setupKafka()

function setupKafka() {
    return new Kafka({
        clientId: `cinema-client-${randomUUID()}`,
        brokers: ['localhost:9092']
    })
}

async function loadTest(path, func) {
    const MAX_ITERATION = Number(process.env.MAX_ITERATION)
    const promises = []
    const timeArray = []
  
    for(let i = 0; i < MAX_ITERATION; i++) {
        promises.push(async () => calculateRequestTime(func))
    }

    for await (let promise of promises) {
        const response = await promise()
        if(response !== -1) timeArray.push(response)
    }
  
    if(!!process.env.SAVE_INFO) {
        await fs.appendFile(path, timeArray.join(",") + "\n");
    }

    exit(0)
}

async function calculateRequestTime(func) {
    try {
        await wait(Math.floor(Math.random() * 100))
       
        const start = getTimeNowInNanoSeconds()
        // const start = Date.now()
        await func(true, kafka)
        // const end = Date.now() - start
        const end = getTimeNowInNanoSeconds() - start;
    
        return end;
    }
    catch(error) {
        return -1;
    }
}

async function wait(delay) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve()
        }, delay)
    })
} 

function getTimeNowInNanoSeconds() {
    const hrTime = process.hrtime()
    const nanoseconds = hrTime[0] * 1000000 + hrTime[1] / 1000

    return nanoseconds
}

module.exports = { loadTest, wait }
