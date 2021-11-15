const dgram = require('dgram')
const { Buffer } = require('buffer')
const { input, question } = require('../utils')

const client = dgram.createSocket('udp4')

function main() {
    input.question(question, answer => {
        switch(answer) {
            case "1": 
                listAllAvailableChairs()
                input.close()
                break
            
            case "2": 
                buyTicket()
                break
        }
    })
}

function listAllAvailableChairs() {
    const data = { op : "List" }
    const message = Buffer.from(JSON.stringify(data))

    send(message)
}

function buyTicket() {
    input.question("Choose a chair\n", question => {
        const data = { op : "Buy", number: Number(question) }
        const message = Buffer.from(JSON.stringify(data))

        send(message)

        input.close()
    })
}

function send(message) {
    client.send(message, 4445, 'localhost', (err) => {
        if(err) console.log(err)
    })

    client.addListener("message", msg => {
        console.log(msg.toString())
        client.close()
    })
}


main()