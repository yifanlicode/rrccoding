
# 网页开发工具 HTML

**Hypertext markup language**

### HTML 基本结构和开头写法

![](images/2022-09-06-22-44-33.png)

```html

<!-- 声明 Html5,卸载最前面 必须写 -->

<!DOCTYPE = html>

<!-- 声明语言，方便网页翻译器 必须写 -->
<html lang="en">

<head>
<!--charset字符集UTF-8为万国符，通码 必须写 -->
    <meta charset="UTF-8">
    <meta name = "viewport" content="width=device-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>This is Our First HTML Page </title>
</head>

<body>
    <header>头部</header>
    <h1>Hello World</h1>
    <p>How is everyone today</p>

    <p>My Favorite website are :</p>
    <ul>  
        <li><a>Google</a></li>
        <li>Red River College</li>
        <li>Twitter</li>
    </ul>
</body>

```



学会
html   <!DOCTYPE html>
html 结构 head（title) body(web 显示也) 写网页名字 
headings 写标题  <h1>
paragraph 写内容段落 <p>
links 插入链接 <a href=""> </a>   href 是属性
images 插入图片 <img src="image.jpg" alt="显示图破了的字” width =“102” height=“102”>


## HTML 元素 
elements 指的是输入排列的内容
<br> 是一个 empty elements / 注意区分 img 是一个 empty tag


## HTML attribute 属性 绿的的浅蓝的部分
    *所有的元素都可以有属性
    *属性是给元素加上额外讯息
    * 属性经常在 start tag被定义
    * Attributes usually come in name/value pairs like: name="value"*

用小写 用 QUOTE“” 双引号
只有本身双引号是 elements 了，采用单引号

举例常用的
href 属性 links ``` <a href=""></a>
src 属性  <img src=""/>```

    > 1. Absolute URL - Links to an external image that is hosted on another website. Example: src="https://www.w3schools.com/images/img_girl.jpg".

  Notes: External images might be under copyright. If you do not get permission to use it, you may be in violation of copyright laws. In addition, you cannot control external images; it can suddenly be removed or changed.

  1. Relative URL - Links to an image that is hosted within the website. Here, the URL does not include the domain name. If the URL begins without a slash, it will be relative to the current page. Example: src="img_girl.jpg". If the URL begins with a slash, it will be relative to the domain. Example: src="/images/img_girl.jpg".

  Tip: It is almost always best to use relative URLs. They will not break if you change domain.

width/height 属性  px

alt 属性 显示图破的时候的讯

style 属性   style ="color:red;"

lang 属性  定义语言的 lang="en"

title 属性 定义元素的额外信息 title 的讯息正常是不现实的，你鼠标放上的时候才显示



### Chapter Summary
All HTML elements can have attributes
The href attribute of <a> specifies the URL of the page the link goes to
The src attribute of <img> specifies the path to the image to be displayed
The width and height attributes of <img> provide size information for images
The alt attribute of <img> provides an alternate text for an image
The style attribute is used to add styles to an element, such as color, font, size, and more
The lang attribute of the <html> tag declares the language of the Web page
The title attribute defines some extra information about an element


一些常用的 tag

Horizontal Rules
<hr>  水平线分隔线
<br> Line breaks 分行显示，a new line

基本的 Html 内的 CSS
![](images/2022-09-06-23-33-28.png)

### HTML Formatting Elements
<b> - Bold text
<strong> - Important text
<i> - Italic text
<em> - Emphasized text
<mark> - Marked text
<small> - Smaller text
<del> - Deleted text
<ins> - Inserted text
<sub> - Subscript text
<sup> - Superscript text
