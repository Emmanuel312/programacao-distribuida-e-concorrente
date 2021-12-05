const { input, question } = require('../utils')
const { resolve } = require("path")
const grpc = require('@grpc/grpc-js')
const protoLoader = require('@grpc/proto-loader')
const PROTO_PATH = resolve(__dirname,'proto','grpc.proto')

const packageDefinition = protoLoader.loadSync(
    PROTO_PATH,
    {
        keepCase: true,
        longs: String,
        enums: String,
        defaults: true,
        oneofs: true
    })


const CinemaDefinition = grpc.loadPackageDefinition(packageDefinition).br.com.cinema.server

const connectionUrl = '127.0.0.1:50051'
const client = new CinemaDefinition.Cinema(connectionUrl, grpc.credentials.createInsecure())

function main() {    
    input.question(question, answer => {
        switch(answer) {
            case '1':
                listAllAvailableChairs(client)
                break
            
            case '2':
                buyTicket(client)
                break
        }
    })
}

function listAllAvailableChairs(client) {
    client.listAllAvailableChairs({}, (response, error) => {
        if(error)
            console.log(error)
        else
            console.log(response)
    })
    input.close()
}

function buyTicket(client) {
    client.buyTicket({ticket: '11'}, (response, error) => {
        if(error)
            console.log(error)
        else
            console.log(response)
    })
    input.close()
}

main()
