/* 
  JavaScipt function demo
  October  25 2022
  yifan
*/

//declaring  variables 声明变量 
//且能用const定义的就不用let，以尽量减少不必要的错误。

let word = "hello";
let fourteen = 7 ;
console.log("let word" + word);
console.log("let fourteen" + fourteen);


// let 是用来声明局部变量 are limited in scope
// var 是用来声明全局变量 代码多容易出错

//1. let 不可以重复定义 但是var可以重复定义
//example
var temp = "This is a temp variable";
var temp = "This is the second temp variable"; //replace the first one

// let 
let cat = "text";
//let cat = "This is the some replace text"; // error 
cat = "This is the some replace text"; // replace the first one

//2.var是函数作用域 ,声明的是全局变量
var word2 = "hello";
var b = 7 ;
// let b = 4 ; //报错  因为前面已经是全局变量了 不能覆盖

//for循环的计数器，就很合适使用let命令。
for(let i=0;i<3;i++){
  console.log(i); //i is visible thus is logged in the console as 0,1,2,3
}
// console.log(i); //throws an error as "i is not defined" because i is not visible


//const 声明的变量是只读的，一旦声明，常量的值就不能改变。
//const 声明的变量必须赋值 
const PI = 3.1415;
//c = 8; //error ;


// 数组 Array 
let days = ["Monday","Tuesday","Wednesday","Thursday","Friday"];

// use getElementByTagName to retrieve a section of the DOM
// 抓取我们的HTML中的所有section标签，并将它们存储在名为section的变量中。
//这将创建一个数组变量，即使在HTML中只有一个section标签。

//[0] 代表第一个section标签 只返回 array[0]
let section = document.getElementsByTagName("section")[0];

// 用innerHTML属性来改变section标签的内容
//<h1>Home</h1> 会被替换成 Hello JavaScript

//section.innerHTML = "Hello JavaScript";

// += 会在原来的内容后面加上新的内容 
section.innerHTML += "Hello JavaScript";

//Template Literals 模板字符串
// 用反引号` `来定义模板字符串
// 用${}来引用变量

// STRING CONCATENATION
console.log('Three plus six is ' + (3 + 6) + '.');
// TEMPLATE LITERALS
console.log(`Three plus six is ${3 + 6}.`);
// "Three plus six is 9."

//USE getElementByID  
let div = document.getElementById("home");
//div.innerHTML = days;
 //这个方法不是很好 因为它会改变原来的数组

 //output days of the week in a loop
 //use template literals to avoid appending

for(let i = 0;i < days.length;i++){
  // div.innerHTML += days[i] + "<br>"; 
  // 使用模板字符串，我们可以在一个字符串中嵌入变量。
  div.innerHTML += `<p>${days[i]}</p>`;
}

// get the class attribute  of the div  抓取div的class属性
let att =div.getAttribute("class");

//change the attribute of the div 改变div的class属性
//因为在css里面我们已经定义了class 这里是给他赋值 就可以执行css里面的样式了 

if(att =="" || att == null){ //如果class属性为空或者不存在
  div.setAttribute("class","main"); //设置class属性为main
}


//函数表达式
//函数表达式是将函数作为值赋给变量的过程。
//函数表达式的语法与函数声明类似，但是函数表达式不会被提升。


//call the function 调用函数
hi();
hello("Yifan");


//let result = favNum(42);
//console.log('Your favorite number,multiplioed by 42 is ${result}');


//调用prompt函数来获取用户输入
//call the prompt function to get user input  prompt("提示信息","默认值");

let num = prompt("what is your favorite number?");
console.log(`Your favorite number,multipliped by 42 is ${favNum(num)}`);


let paragraph = document.getElementsByTagName("p");
for(let i = 0;i < paragraph.length;i++){
  paragraph[i].setAttribute("style","background-color:orange;");
}


