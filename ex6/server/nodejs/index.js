var PROTO_PATH = '../../proto/grpc.proto';

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

function buyTicket(call, callback){
  console.log('Ticket ' + call.request.ticket + ' comprado')
  callback(null, {replyTicket: 'Ticket ' + call.request.ticket + ' comprado'})
}

function listAllAvailableChairs(call, callback){
  callback(null, {chairReply: 'Reply das cadeiras disponíveis'})
}

function main() {
  var server = new grpc.Server();
  server.addService(cinema_proto.Cinema.service, {
    buyTicket: buyTicket,
    listAllAvailableChairs: listAllAvailableChairs
  });
  server.bindAsync('0.0.0.0:50051', grpc.ServerCredentials.createInsecure(), () => {
    server.start();
  });
}

main();