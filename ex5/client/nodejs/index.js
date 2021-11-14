import dgram from 'dgram';
import { Buffer } from 'buffer';

const data = { op : "List" }

const message = Buffer.from(JSON.stringify(data));

const client = dgram.createSocket('udp4');

client.send(message, 4445, 'localhost', (err) => {
    client.close();
});