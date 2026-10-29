// const fs = require("fs");

// console.log("before read");

// fs.writeFile("test.txt","helo from node",(error)=>{
//     if(error){
//         console.error(error);
//         return;
//     }
//     console.log("write completed");
// });

// console.log("after write");

//read file

const fs = require("fs");

// const data = fs.readFileSync("test.txt");

// console.log(data.toString());


// async read

console.log("before read");

fs.readFile("test.txt",(error,data)=>{
    if(error){
        console.error(error);
        return;
    }

    console.log(data.toString());
});

console.log("after read");