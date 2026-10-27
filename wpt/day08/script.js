// closures

// basically provides encapsulation

function createCounter() {
  let count = 0;
  return function () {
    count++;
    return count;
  };
}

const counterA = createCounter();
console.log(counterA());
console.log(counterA());

const counterB = createCounter();
console.log(counterB());
console.log(counterB());

// so call stack and heap

// first line call stack gets exe context of createC and lexical env(add of func) at heap as it has a inner func then engine reaches inner func which belongs to parent so keeps it in haep and its obj is liked with parents obj a hidden link then outer exe finished removed from call stack but the count var still lives in inner func so when we exe inner func and coint from 0 to 1 it also changes parent obj val as both linked and thus count survives this is usedful for encapsultaion and data sec
//callback

function runTask(taskname, onComplete) {
  console.log(`Working on ${taskname}`);
  onComplete();
}

runTask("html form", () => console.log("Task done"));

//objects

const project = {
  title: "Portfolio",
  status: "done",
  describe() {
    return `${this.title} : ${this.status}`;
  },
};

console.log(project.title);
console.log(project.describe());

const propertyName = "title";
console.log(project[propertyName]);

//this binding
const describeProject = project.describe();
console.log(describeProject);

//prototype

const basicUser = {
  introduce() {
    return `I an ${this.name}`;
  },
};

const learner = Object.create(basicUser);
learner.name = "Satyam";

console.log(learner.introduce());
console.log(Object.hasOwn(learner, "name"));
console.log(Object.hasOwn(learner, "introduce"));

//synnols

const internalIda = Symbol("id");
const internalIdb = Symbol("id");
const recorda = {
  [internalIda]: 123,
  name: "Project A",
};
const recordb = {
  [internalIdb]: 123,
  name: "Project B",
};
const internalIdc = "id";
const internalIdd = "id";
const recordc = {
  [internalIdc]: 123,
  name: "Project A",
};
const recordd = {
  [internalIdd]: 1234,
  name: "Project B",
};

console.log(recorda[internalIda]);
console.log(recordb[internalIdb]);
console.log(recorda[internalIda] === recordb[internalIdb]);
console.log(recordd[internalIdc]);
console.log(recordd[internalIdd]);

// oops

class studyTask {
  constructor(title, minutes) {
    this.title = title;
    this.minutes = minutes;
    this.completed = false;
  }

  markCompleted() {
    this.completed = true;
  }

  describe() {
    const state = this.completed ? "done" : "not done";
    return `${this.title} - ${this.minutes} min - ${state}`;
  }
}

//inheritance

class codingTask extends studyTask {
  constructor(title, minutes, language) {
    super(title, minutes);
    this.language = language;
  }

  describe() {
    return `${super.describe()} - lang:${this.language}`;
  }
}

const htmlTask = new studyTask("HTML prac", 20);
const jsTask = new codingTask("jS prac", 50, "JS");

htmlTask.markCompleted();
console.log(htmlTask.describe());
console.log(jsTask.describe());
//overriden automatically

// private field uses #

//iterator generators functional programming

for (const topic of ["HTML", "CSS", "JS"]) {
  console.log(topic);
}

function* topicSequence() {
  yield "CSS";
  yield "JS";
  yield "HTML";
}

for (const topic of topicSequence()) {
  console.log(topic);
}

function addTax(price, rate) {
  return price + price * rate;
} //pure func

const original = [10, 20, 30];
const doubled = original.map((value) => value * 2);

console.log(addTax(100, 0.18)); //pure func
console.log(addTax(100, 0.18)); //pure func
console.log(original);
console.log(doubled);

// async programming
console.log("start");
setTimeout(() => console.log("mid"), 1000);
console.log("end");

//callback hell

function findUser(id, callback) {
  setTimeout(() => {
    if (!id) {
      callback(new Error("User ID is required"), null);
      return;
    }

    callback(null, { id, name: "Mina" });
  }, 1000);
}

findUser(7, (error, user) => {
  if (error) {
    console.error(error.message);
    return;
  }
  console.log(user.name);
});

// if chain of callbacks deeply nested forming a growing pyramid basically creating a dependent async steps to solve this promise

//promises
function getId(id) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (!id) {
        reject(new error("User id is required"));
        return;
      }

      resolve({ id, name: "Satyam" });
    }, 1000);
  });
}

getId(8)
  .then((user) => {
    console.log(user.name);
    return user.id;
  })
  .then((id) => {
    console.log("User id is " + id);
  })
  .catch((error) => console.error(error.message))
  .finally(() => console.log("Done"));


function sum(a,b) {
    return new Promise ((resolve,reject) => {
        setTimeout(()=>{
            if(a>100 || b>100){
                reject(new error("vals not larger than 100"));
                return;
            }
            resolve(a+b);
        },1000);
    });
}

function factorial(a){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            if(a<0){
                reject(console.error("no should be atleast 0"));
                return;
            }
            let result = 1;
            for(let iTmp = 1;iTmp<=a;iTmp++){
                result*=iTmp;
            }
            resolve(result);
        },1000);
    });
}

function square(num){
    return new Promise((resolve)=>{
        setTimeout(()=>{
            resolve(num*num);
        },1000);
    });
}

sum(2,3)
.then(sumRes=>{
    console.log("Sum is "+sumRes);
    return factorial(sumRes);
}).then(fact=>{
    console.log("Fact is " +fact);
    return square(fact);
}).then(squareRes=>{
    console.log("Square is "+squareRes);
}).catch((error)=>{console.log(error)});


// .then hell so async await
async function showUser(){
    try{
        const id = await getId(2);
        console.log(id.id);
        console.log(id.name);
    } catch (error){
        console.error(error.message);
    } finally {
        console.log("finally done");
    }
}

showUser();

//sequential and concurrent work

async function getProjects(){
    try{
        const response = await fetch(
          "https://api.github.com/users/SatyamBhosale2004/repos"
        );
        if(!response.ok){
            throw new Error(`HTTPS error status ${response.status}`);
        }
        const projects = await response.json();
        console.log(projects);
    } catch(error){
        console.log(error.message);
    }
}

getProjects();