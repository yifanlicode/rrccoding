## Form Validation



## User Experience

表单验证是为了改进用户体验

Have you ever had a bad experience filling a form out online? We all have. A lot of these frustrations can be eliminated with proper planning of how a form’s data is validated. 

没有 JS 之前，填写表单如果出现错误，就要重新刷新界面，或者重新填写。这会带来很差的 User Experience.

User experience is extremely important. Customers have been lost because of bad form validation strategies. 

> They may have been close to making a purchase, only to stop and leave the website because form instructions were unclear, error messages were vague, and data had to be filled out again. 



A Validation Gameplan

Javascript allows us to do client-side validation. That means that before the form data is even sent anywhere, we can check to make sure it meets all of our requirements ***before*** the form is submitted. 

But we should allow the users freedom to fill out all the inputs, then check for validity once they click the submit button. 

Consider this form below:

![img](file:////Users/liyifan/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image002.jpg)

There are just three text inputs here, but there are things to consider. What data do we expect? Are all three similar types of data? Can we check all of them at once or do we have to do them separately? What happens when the form is first submitted?



## 表单基础设置

#### handle submission of the form 

```js

function load() {
	document.getElementById("survey_form").addEventListener("submit", validate);

	// Reset the form using the default browser reset 重置表单 使用默认浏览器重置
	// This line of code must be done before attaching the event listener for the customer reset   
	document.getElementById("survey_form").reset(); 

	// 点击 reset 之后 radio button are cleared as well. 
	//因为默认状态下,如果你刷新页面,radio button is  going to stay clicked 
	document.getElementById("survey_form").addEventListener("reset", resetForm);

	// Anonymous Functions 
	document.getElementById("bit").addEventListener("click",
			function() { showMajor("bit"); });
	document.getElementById("ba").addEventListener("click",
			function() { showMajor("ba"); });
	
	// 在专业部分添加文本字段的事件侦听器
	document.getElementById("aviation").addEventListener("click",hideMajor);
	document.getElementById("accounting").addEventListener("click",hideMajor);
}
```

First we have to handle submission of the form. 

> Notice here this is not the *click* event of the button, but the *submit* event of the form. 

The user can also use the enter key to submit a form. 

Here we’re running a function called `validate()`when the form is submitted.

这里调用了`validate` fuction，需要设置验证规则。



#### Anonymous Functions

We’ve used event listeners, but one issue with them is that they are just references to functions; not calls of functions. This means that we can’t pass values to them. But what we can do is create an *anonymous function* that will be executed only when the event takes place. 

事件监听器只是对函数的引用；而不是对函数的调用。这意味着我们不能向它们传递值。但我们可以做的是创建一个*匿名的函数*，只有当事件发生时才会被执行。

See the example below:

```js
// Anonymous Functions 
document.getElementById("bit").addEventListener("click",
 function() { showMajor("bit"); });
document.getElementById("ba").addEventListener("click",
  function() { showMajor("ba"); });
```

We have a function that should run when a radio button is clicked. But this function is expecting a value. 

So rather than just referencing this function in our addEventListener, we’ll create an anonymous function, and call the function in there.



#### error validate

```js
/*
 * Handles the submit event of the survey form
 *
 * param e  A reference to the submit event
 * return   True if no validation errors; False if the form has
 *          validation errors
 */

function validate(e) {
	//	Hides all error elements on the page
	hideAllErrors();
	//alert("here");
	//	Determine if the form has errors  如果表单有错误
	if (formHasErrors()) { // 如果有错误,是 true
		// 	Prevents the form from submitting 防止表单提交
		e.preventDefault(); 
		return false; 
	}
	return true; //true的话 才能运行该功能
}

```

##### preventDefault

The `preventDefault()` method tells the [user agent](https://developer.mozilla.org/en-US/docs/Glossary/user_agent) that if the event does not get explicitly handled, its default action should not be taken as it normally would be.

- If there are errors in the user data, then we must prevent the form from submitting. 

- If there are no errors, then we allow the form to submit.
-  The `formHasErrors() `function will check all the inputs to see if there are any errors and return true if there are errors, and false if there aren’t. 



### 表单错误检查（这是最难写的地方）

根据表单需要输入的内容多少来设置检查项。



### Common Checks 常规检查

#### 检查 textbox （用户是否输入字符）

 ![img](file:////Users/liyifan/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image008.jpg)

The most common form-data-validation is checking a textbox for any number of characters.

Here we’ve retrieved the value out of the textbox, and checked to see if there was any data entered. 

首先获取用户输入的值

Now if there was an issue with the data, we have to display an appropriate error message to the user. This is where checking all validations on submit is an advantage.

检查用户数据是否有问题，如果有问题，显示错误Error讯息

A common way to display error messages is to create them inside the markup, have them hidden with CSS, then display them as needed in Javascript.

一个常用的方法就是：在 HTML 里面创建错误信息，用 CSS 隐藏起来，然后通过 JS 显示出来。

```html
<div class="formfield">
		<label for="fname" class="student">First Name:</label>
		<input type="text" id="fname" name="fname"  maxlength="15" value="" autofocus="autofocus" />		
<!-- class error 是为了用 css 全部隐藏起来, id error是为了 JS 使用 -->
    <div class="student_error error" id="fname_error">* Please enter your first name.</div>
</div>
```

Notice the id attribute. We’ve added “_error” to the id of the input that this error message is tied to. This makes it easier in the Javascript to access the appropriate error message. 

错误信息需要设置 class 和 id, class 是为了用 CSS 一并隐藏起来，ID 是为了 JS 调用。ID 的命名最好有相同的字段比如`_error`，是为了调用方便

![img](file:////Users/liyifan/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image012.jpg)

 

Radio buttons and checkboxes can be checked using the *check* property. Here we have four radio buttons, and created an array of their id attributes so we can use a loop to check all of them in one block of code.![img](file:////Users/liyifan/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image014.jpg)

![img](file:////Users/liyifan/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image016.jpg)



#### Regular Expressions  检查格式

Regular Expressions are used in validation to determine if data matches a pattern. For example, if we were to say that a student number had to be a 6 digit integer, we could create a regular expression pattern, and then test that pattern against what the user entered, like so:

![img](file:////Users/liyifan/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image022.jpg)

You can see that regular expression syntax can be funky. If you need regular expressions, some research will show that many people have already created them. Use those in your code!

**NOTE:** In this course we want you to know what regular expressions are and what they can do, but you don’t have to write them yourselves.

#### Setting Focus to Inputs  聚焦输入框

Setting focus to an input is a very simple, yet important feature to add to any form validation. As you can see with the code below, it’s as simple as calling the *focus()* method. 

![img](file:////Users/liyifan/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image024.jpg)

The *select()* will highlight any text within the textbox that may have been in error (an invalid postal code for example). 

 

 

 