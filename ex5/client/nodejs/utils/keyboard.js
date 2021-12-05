const { createInterface } = require('readline')

const question = "1 - To list all available chairs\n2 - To buy a ticket\n"

const input = createInterface({
    input: process.stdin,
    output: process.stdout
});

module.exports = {question, input}