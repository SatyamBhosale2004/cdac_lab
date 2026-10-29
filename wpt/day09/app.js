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

// const fs = require("fs");

// const data = fs.readFileSync("test.txt");

// console.log(data.toString());


// async read

// console.log("before read");

// fs.readFile("test.txt",(error,data)=>{
//     if(error){
//         console.error(error);
//         return;
//     }

//     console.log(data.toString());
// });

// console.log("after read");

//htp server

// const http = require("http");

// const server = http.createServer((request,response)=>{
//     response.write("from server");
//     response.end();
// });

// server.listen(6500);

// const mymodule = require("./mymodule.js");
// import product, {sum} from "./mymodule.js";
// console.log(sum(2,3));
// console.log(product(2,3));

// express

import express from "express";

const app = express();

// app.get("/",(req,res)=>{
//     res.status(200).send({message: "hello from express"});
// });

// app.get("/login",(req,res)=>{
//     res.send("login page");
// });

// app.get("/sum",(req,res)=>{
//     const result = 1+9; 
//     res.send(`sum page and result is ${result}`);
// });

app.listen(6500, () => {
    console.log("server running");  
});

//url param

// app.get("/sum/:a/:b",(req,res)=>{
//     const a = Number.parseInt(req.params.a,10);
//     const b = Number.parseInt(req.params.b,10);
//     res.send({sum:a+b});
// });

//middleware
// const myMiddleWare = (req,res,next) => {
//     console.log("in middleware");
//     next();
// };

// app.get("/",myMiddleWare,(req,res)=>{
//     res.send("hello with middleware");
// });

// app.use(myMiddleWare);

// app.get("/",(req,res)=>{
//     res.send("nigga");
// });

// app.get("/login",(req,res)=>{
//     res.send("login");
// })

app.use(express.json());

app.get("/factorial/:num",(req,res)=>{
    const num = Number.parseInt(req.params.num,10);

    if(Number.isNaN(num) || num < 0){
        res.status(400).send("negative no.");
    }

    let result = 1;
    for(let iTmp=1;iTmp<=num;iTmp++){
        result*=iTmp;
    }
    res.send({factorial:result});
});

app.post("/sum",(req,res)=>{
    const {a,b} = req.body;

    res.send({sum:a+b});
});
