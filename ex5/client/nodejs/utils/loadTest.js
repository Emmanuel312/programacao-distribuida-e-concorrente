const fs = require("fs/promises");
const { exit } = require("process");

async function loadTest(path, func) {
    const MAX_ITERATION = Number(process.env.MAX_ITERATION)
    const promises = []
    const timeArray = []
  
    for(let i = 0; i < MAX_ITERATION; i++) {
        promises.push(async () => calculateRequestTime(func))
    }

    for await (let promise of promises) {
        if(await promise() !== -1) timeArray.push(await promise())
    }
  
    if(!!process.env.SAVE_INFO) {
        await fs.appendFile(path, timeArray.join(",") + "\n");
    }

    exit(0)
}

async function calculateRequestTime(func) {
    try {
        await wait(Math.floor(Math.random() * 10))
       
        const start = getTimeNowInNanoSeconds()
        // const start = Date.now()
        await func(true)
        // const end = Date.now() - start
        const end = getTimeNowInNanoSeconds() - start;
    
        return end;
    }
    catch(error) {
        return -1;
    }
}

async function wait(delay) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve()
        }, delay)
    })
} 

function getTimeNowInNanoSeconds() {
    const hrTime = process.hrtime()
    const nanoseconds = hrTime[0] * 1000000 + hrTime[1] / 1000

    return nanoseconds
}

module.exports = { loadTest, wait }
