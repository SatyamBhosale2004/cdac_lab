console.log("hello js");
const firstNo = 1;
const secondNo = 8;
console.log(firstNo + secondNo);

const course = "pgcp-ac";
let difficulty = "professional";
console.log(course);
console.log(difficulty);
difficulty = "moderate";
// course = "pgcp-ai";
// console.log(course);//typeerror as we are changing teh variable binding means varibale is binded to a
console.log(difficulty);
const modules = ["dbt", "ads", "cpp", "oopj", "wpt"];
console.log(modules);
modules.push("wpj"); //no typeerror as we are not reassignning the variable binding but mutation of value is allowed
console.log(modules);

const topics = [
  { name: "HTML", minutes: 35 },
  { name: "CSS", minutes: 44 },
  { name: "JS", minutes: 88 },
];

const totalMinutes = topics.reduce((total, topic) => total + topic.minutes, 0);
const completedTopic = topics.map((topic) => topic.name);
const longSessions = topics.filter((topic) => topic.minutes >= 40);

console.log(`Total study time : ${totalMinutes}`);
console.log(completedTopic);
console.log(longSessions);

// Write a program that stores a test score, checks whether it is between 0 and 100, and prints `Excellent` (80+), `Pass` (50–79), or `Needs practice` (below 50). Reject invalid input rather than treating it as a score.

const test_scores = [80, 79, 50, 30, 0, 99];

for (let score of test_scores) {
  if (score >= 80 && score < 100) {
    console.log("Excellent");
  } else if (score >= 50 && score < 79) {
    console.log("Pass");
  } else if (score < 50 && score >= 0) {
    console.log("Needs Practice");
  }
}
// q2
// Take a full-name string with extra spaces, trim it, display it in uppercase, and print the current year. Explain why `getMonth()` does not directly produce a human month number.

const str = " hello world ";
console.log(str.toUpperCase());
console.log(new Date().getMonth()+1);
// q3
// Create an array of at least six numeric scores. Produce a new array containing scores of 50 or higher, a second array with five points added to every score, and the total score.

console.log(test_scores.filter(score => score >= 50));
console.log(test_scores.map(score => score+5));
console.log(test_scores.reduce((total_score,score) => total_score+score,0));


// Take a small program that builds a sentence using `+` and object property access. Rewrite it using a template literal and destructuring. Add a sensible fallback with `??` for a missing value. If you're ready, export a helper from a second file and import it into the entry file.
let words = {
    word1: "Nigga",
    word2: " Says ",
    word3: "Hello",
    word4:"",
};

let str1 = words.word1+words.word2+words.word3 ;
console.log(str1);


console.log(`${words.word1}${words.word2}${words.word3}`);
let {word1,word2,word3,word4} = words;
console.log(word1,word2,word3,word4||0);
console.log(word1,word2,word3,word4??0);




