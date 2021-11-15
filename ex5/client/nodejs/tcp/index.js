const net = require('net')
const { input, question } = require('../utils')

const client = new net.Socket({})

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
    const message = Buffer.from(JSON.stringify(data) + '\n')

    send(message)
}

function buyTicket() {
    input.question("Choose a chair\n", question => {
        const data = { op : "Buy", number: Number(question) }
        const message = Buffer.from(JSON.stringify(data) + '\n')

        send(message)

        input.close()
    })
}

function send(message) {
    let received = ""

    client.connect(4446, '127.0.0.1', () => {
        client.write(message)
    })
    
    client.addListener("data", data => {
        received += data.toString()
    })

    client.addListener("end", () => {
        console.log(received)
    })
}


main()
