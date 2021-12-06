const dgram = require('dgram')
const { Buffer } = require('buffer')
const { question } = require('../utils/keyboard')
const { loadTest, wait } = require('../utils/loadTest')
const { resolve } = require("path")

async function main(loadTest = false) {
    const client = dgram.createSocket('udp4')

    if(loadTest) {
        await listAllAvailableChairs(client)
    }
    else
        input.question(question, async answer => {
            switch(answer) {
                case "1": 
                    await listAllAvailableChairs(client)
                    input.close()
                    break
                
                case "2": 
                    await buyTicket(client)
                    input.close()
                    break
            }
        })
}

async function listAllAvailableChairs(client) {
    const data = { op : "List" }
    const message = Buffer.from(JSON.stringify(data))

    await send(client, message)
}

async function buyTicket(client) {
    input.question("Choose a chair\n", async question => {
        const data = { op : "Buy", number: Number(question) }
        const message = Buffer.from(JSON.stringify(data))

        await send(client, message)
    })
}

async function send(client, message) {
    return new Promise((resolve, reject) => {
        client.send(message, 4445, 'localhost', async (err) => {
            // console.log("connected")
            if(err) reject()
            await wait(1000)
            resolve()
        })
    
        client.addListener("message", msg => {
            // client.close()
            resolve()
        })

        client.addListener("error", error => {
            console.log(error)
            reject()
        })
    })
}


loadTest(resolve(__dirname, "..", "..", "..", "..", "loadTest", "data", "./udp.txt"), async (isLoad) => main(isLoad))