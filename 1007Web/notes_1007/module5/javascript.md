# JavaScript  

JavaScript is one of the 3 languages all web developers must learn:

   1. HTML to define the content of web pages
   2. CSS to specify the layout of web pages
   3. JavaScript to program the behavior of web pages

JavaScript (CASE SENSITIVE!) is the programming language of the web. You can use it to add dynamic behavior, store information, and handle requests and responses on a website. This course sequence covers data types and structures, functions, and object-oriented programming with classical inheritance in ES6 syntax.


Javascript is also different from most languages, as **it’s interpreted, not compiled** 

That means that you won’t know that you have syntax errors until you run it in the browser.

## JavaScript 书写位置

1.内部 JavaScript
直接写在 HTML 文件里,使用 Script 标签包住
规范:script标签写在`</body>`的上面.(专业)
```HTML
<body>
  <h1>hi</h1>
  <script>
    /*弹出警示框*/
    alert('hello JS')
  </script>
</body>
```

/we’re ensuring that the browser has created all the tags above it. This is important as we may reference tags inside our HTML. 

2. 外部 JS (多用这个)
代码写在 .js 结尾
语法:通过 script 标签 引入到 html 页面


```html
<body>
   <script src="myScript.js"></script>
</body>

```




## Variables


The JavaScript syntax defines two types of values:
- Fixed values are called Literals.
- Variable values are called Variables.

variables are used to store data values.
变量不是数据本身,而是容器.


### Declaring Variables

- Using var (全局变量 开始之初就有了 容易出错 可重复赋值)
- Using let  * 比较新  变量
- Using const  * 比较新 常量



`var` has been used since its inception, and will declare variables in function or **global scope**. Declaring variables globally can often be problematic, especially with a lot of lines of code. 

```js
const price1 = 5;
const price2 = 6;
let total = price1 + price2;
let x = 6, y = 8; //合并
```

### Declaring arrays

```js
let days = ["Monday", "Tuesday","Thursday"];
// Thursday 是 array[2]
```



## Javascript Methods

### access HTML elements

 there are 2 common methods that we can use
 `getElementsByTagName`  `getElementByID`

```js
let section = document.getElementsByTagName("section");
//This creates an array variable, even if there was only one section tag in the HTML.

let section = document.getElementsByTagName("section")[0];
//dd an index at the end to a specify one 

```

```js
let div = document.getElementById("home");
```


There are newer methods that you can use if you like to retrieve elements from the HTML. The `querySelector` and `querySelectorAll` methods use CSS selectors as parameters to retrieve elements. 

### querySelector() & querySelectorAll()

The `querySelector()` method returns the **first** element that matches a CSS selector.

To return **all** matches (not only the first), use the `querySelectorAll()` instead.

Both `querySelector()` and `querySelectorAll()` throw a SYNTAX_ERR exception if the selector(s) is invalid.


```js
//Get the first <p> element:
document.querySelector("p");
//Get the first element with class="example":
document.querySelector(".example");
```








## Creating OUTPUT

### Writing into an alert box, using `alert()`. 警示框

`<script>alert(5 + 6);</script>`

### Writing into the browser console, using `console.log()` 
For debugging purposes, you can call the console.log() method in the browser to display data.
`console.log(5 + 6); `

### Writing into an HTML element, using `innerHTML`.

在元素后面,跟  `.innerHTML` property defines the HTML content:

```js
section.innerHTML += world;
```

```html
<p id="demo"></p>
<script>
document.getElementById("demo").innerHTML = 5 + 6;
</script>
```

Changing the innerHTML property of an HTML element is a common way to display data in HTML.

那,如何输出数组呢,我们可以用 loops

```js
for(let i = 0;i < days.length;i++){
  // div.innerHTML += days[i]; 一行显示的
  // 使用模板字符串 template literals，我们可以在一个字符串中嵌入变量。
  div.innerHTML += `<p>${days[i]}</p>`;
}
```

 template literals
backtick character (`)


## Functions

Functions are quite easy to create in Javascript. Here’s a simple function:


```js
function hi(){
   console.log("hello,Dave");
}

function hello(name){
   console.log(`hello,${name}`);
}


function favNum(number){
   reture number * 42;
}
```

## The Document Object Model (DOM)

The `Document Object Model (DOM)` is the data representation of the objects that comprise the structure and content of a document on the web. In this guide, we'll briefly introduce the DOM. We'll look at how the DOM represents an HTML or XML document in memory and how you use APIs to create web content and applications.


When the browser loads a webpage, it creates a `DOM` for the page. It treats the `elements` as `objects`. 

These `objects` have children, siblings, and parents. All of these `objects` have methods and properties that we can use to access and manipulate the elements. 

If we wanted to change the `class attribute` of an element, we can do so using the `setAttribute` method:

```  
div.setAttribute("class","main"); //设置class属性为main
```

## Event Listeners


Javascript events provide a dynamic interface to a webpage. These events are hooked to elements in the Document Object Model(DOM).

We use listeners to determine what happens when an event occurs. For example, if a button is clicked, then the click event is triggered, and perhaps a function is called to decide the next course of action. 

Remember earlier when we had a script tag inside our `<body> `tag? I mentioned then that is probably not the best way to handle it. There is an event that occurs when the browser has completed loading the DOM. 

如果我们使用监听,就不必把 `script` 的标签放在 body 最下面了,我们可以把它放在 `head`里面.DOM 加载后,就可以开始 script.

When the DOMContentLoaded event is triggered, then the load function will be called. This allows us to put our `<script> `tag inside the` <head>` tag. Once the DOM is loaded we can start our script.


```js
document.addEventListener("DOMContentLoaded",load);
function load(){}
```


