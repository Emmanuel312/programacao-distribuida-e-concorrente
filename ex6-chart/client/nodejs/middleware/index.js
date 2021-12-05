const net = require('net')
const fs = require('fs');
const { input, question } = require('../utils')


const client = new net.Socket({})

function main() {
    const MAX_ITERATION = process.env.MAX_ITERATION
    let timeArray = []
    // console.log("oi eu sou um script em node realizando uma requisição")
    for (let iteration = 0; iteration < MAX_ITERATION; iteration++) {
        var start = Date.now();
        // aqui vc coloca a função de realizar uma requisição propriamente dita
        for (let delay = 0; delay < 10000; delay++) {
            for (let delay2 = 0; delay2 < 100; delay2++) {
                let a =2
            }
        }
        // console.log("oi eu sou um script em node realizando uma requisição", iteration)
        
        // input.question(question, answer => {
        //     switch(answer) {
        //         case "1": 
        //             listAllAvailableChairs()
        //             input.close()
        //             break
        
        //         case "2": 
        //             buyTicket()
        //             break
        //     }
        // })
        var time = Date.now() - start;
        timeArray.push(time)
        
    }
    if(process.env.SAVE_INFO === 'TRUE'){
        
        fs.appendFileSync('./middleware.txt', String(timeArray));
    }
    // comentar essa linha quando o serve estiver pronto
    process.exit(0)
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
