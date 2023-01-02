/* 
  JavaScipt function demo
  October  25 2022
  yifan
*/


//FUNCTIONS 函数
//函数是JavaScript中的一等公民，可以像其他变量一样被传递和使用。
//函数可以作为参数传递给另一个函数，也可以作为另一个函数的返回值。
//函数可以被赋值给变量，数组元素或对象属性。


//function 函数 有两种定义方式
//name 是函数名 ()是参数列表  {}是函数体
//1. function name(){};
//2. const name = function(){};

//1. function name(){};
function hi(){
    //alert("Hi"); //deBug 的时候 弹出框 但程序会停止 阻塞代码 
    console.log("Hi");//不会阻塞代码 输出到控制台 
}

// hello()括号里面的参数是传递给函数的值 
//这些值叫做实参 用来传递给形参的值

function hello(name){
    console.log(`Hello, ${name}`);
}


function favNum(number){
    return number * 42;
}

