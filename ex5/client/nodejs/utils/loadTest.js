const fs = require("fs");
const { exit } = require("process");

async function loadTest(path, func) {
    const MAX_ITERATION = Number(process.env.MAX_ITERATION)
    const promises = []
    const timeArray = []
  
    for(let i = 0; i < MAX_ITERATION; i++) promises.push(calculateRequestTime(func))

    for await (let result of promises) {
        timeArray.push(result)
    }
 
    if(process.env.SAVE_INFO) {
        fs.appendFileSync(path, timeArray.join(",") + ",");
    }

    exit(0)
}

async function calculateRequestTime(func) {
    const start = Date.now();
    await func(true)
    const time = Date.now() - start;

    return time;
}

module.exports = { loadTest }
