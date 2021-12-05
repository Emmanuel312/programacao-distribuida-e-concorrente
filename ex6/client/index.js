const { input, question } = require('../utils')
const { resolve } = require("path")
const grpc = require('@grpc/grpc-js')
const protoLoader = require('@grpc/proto-loader')
const { loadTest } = require("../../ex5/client/nodejs/utils/loadTest")

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

async function main(IsLoad = false) {    
    if(IsLoad) 
        listAllAvailableChairs(client)
    else
        input.question(question, answer => {
            switch(answer) {
                case '1':
                    listAllAvailableChairs(client)
                    input.close()
                    break
                
                case '2':
                    buyTicket(client)
                    break
            }
        })
}

async function listAllAvailableChairs(client) {
    return new Promise((resolve, reject) => {
        client.listAllAvailableChairs({}, (response, error) => {
            if(error) {
                console.log(error)
                reject()
            }
            else {
                console.log(response)
                resolve()
            }
        })
    })
}

async function buyTicket(client) {
    return new Promise((resolve, reject) => { 
        client.buyTicket({ticket: '11'}, (response, error) => {
            if(error) {
                console.log(error)
                reject()
            }
            else {
                console.log(response)
                resolve()
            }
        })
    })
}

loadTest(resolve(__dirname, "..", "..", "loadTest", "data", "./middleware.txt"), async (IsLoad) => await main(IsLoad))