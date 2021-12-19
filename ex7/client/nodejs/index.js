const { input, question } = require('./utils/keyboard')
const { resolve } = require("path")
const { randomUUID } = require('crypto')
const { publish } = require('./producer')
const { consume } = require('./consumer')
const { loadTest } = require('./utils/loadTest')
const { exit } = require('process')


const requestsId = new Set()

async function main(IsLoad = false, kafka) {   
    try {
        consume(kafka, `cinema-client-group-${randomUUID()}`, "cinema-response", responseListener)
    
        if(IsLoad) 
            listAllAvailableChairs(kafka)
        else
            input.question(question, answer => {
                switch(answer) {
                    case '1':
                        listAllAvailableChairs(kafka)
                        input.close()
                        break
                    
                    case '2':
                        buyTicket(kafka)
                        input.close()
                        break
                }
            })
    } catch (error) {
        console.log(error)
    }
}

async function listAllAvailableChairs(kafka) {
    const data = { op: "List" }

    await send(kafka, data)
}


async function buyTicket(kafka) {
    const data = { op: "Buy", number: 1 }

    await send(kafka, data)
    exit(0)
}


async function responseListener(key, message) {
    if(requestsId.has(key)) {
        // console.log(message)
        return true
    }
    
    return false
}

async function send(kafka, data) {
    const correlationId = randomUUID()
    await publish(kafka, "cinema-request", correlationId, JSON.stringify(data))
    requestsId.add(correlationId)
}

// main()

loadTest(resolve(__dirname, "..", "..", "..", "loadTest", "data", "./mom.txt"), async (IsLoad, kafka) => await main(IsLoad, kafka))