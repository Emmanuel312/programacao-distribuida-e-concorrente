var PROTO_PATH = '/../proto/grpc.proto';
var grpc = require('@grpc/grpc-js');
var protoLoader = require('@grpc/proto-loader');
var packageDefinition = protoLoader.loadSync(
    PROTO_PATH,
    {
        keepCase: true,
        longs: String,
        enums: String,
        defaults: true,
        oneofs: true
    });
var cinema_proto = grpc.loadPackageDefinition(packageDefinition).cinema;

function main() {
    var target = 'localhost:50051';
    var client = new cinema_proto.Cinema(
        target,
        grpc.credentials.createInsecure()
    );
    var index;
    while(index != '0') {
        input.question(question, answer => {
            index = answer;
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


}

function listAllAvailableChairs(client) {
    client.listAllAvailableChairs((response, error) => {
        if(error)
            console.log(error)
        else
            console.log(response.chairReply)
    })
}

function buyTicket(client) {
    client.buyTicket({ticket: '10'}, (response, error) => {
        if(error)
            console.log(error)
        else
            console.log(response.replyTicket)
    })
}

main();
