const fs = require("fs");

console.log("before read");

fs.writeFile("test.txt","helo from node",(error)=>{
    if(error){
        console.error(error);
        return;
    }
    console.log("write completed");
});

console.log("after write");

