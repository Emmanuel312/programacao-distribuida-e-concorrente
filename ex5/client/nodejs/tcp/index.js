const net = require('net')
const { question } = require('../utils/keyboard')
const { loadTest, wait } = require('../utils/loadTest')
const { resolve } = require("path")

async function main(IsLoad = false) {
    const client = new net.Socket({})
    if(IsLoad)
        await listAllAvailableChairs(client)
        
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
    const message = Buffer.from(JSON.stringify(data) + '\n')

    await send(client, message)
}

async function buyTicket(client) {
    input.question("Choose a chair\n", async question => {
        const data = { op : "Buy", number: Number(question) }
        const message = Buffer.from(JSON.stringify(data) + '\n')

        await send(client, message)
    })
}

async function send(client, message) {
    return new Promise((resolve, reject) => {
        let received = ""

        client.connect(4446, '127.0.0.1', async () => {
            client.write(message)
        
        })
        
        client.addListener("data", data => {
            received += data.toString()
        })
    
        client.addListener("end", () => {
            // console.log("end")
            resolve()
        })
    
        client.addListener("error", error => {
            console.log(error)
            reject()
        })
    })
}

loadTest(resolve(__dirname, "..", "..", "..", "..", "loadTest", "data", "./tcp.txt"), async (IsLoad) => await main(IsLoad))


