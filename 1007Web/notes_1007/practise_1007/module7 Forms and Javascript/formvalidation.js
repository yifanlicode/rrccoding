/*
	Survey Form Validation
	Today's Date 2022-11-07 22:38:58
	Learn 2 time : 2022-11-30 
	yifan
 */


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
 	if (formHasErrors()) { // 如果有错误
		// 	Prevents the form from submitting 防止表单提交
		e.preventDefault(); 
		return false; 
	}
	return true; //true的话 才能运行该功能
}

/*
 * Handles the reset event for the form. 
 *
 * param e A reference to the reset event
 * return  True allows the reset to happen; False prevents
 *         the browser from resetting the form.
 */

function resetForm(e) {
	// Confirm that the user wants to reset the form.
	if (confirm('Clear survey?')) {
		// Ensure all error fields are hidden
		hideAllErrors();

		// Set focus to the first text field on the page
		document.getElementById("fname").focus();

		// When using onReset="resetForm()" in markup, returning true will allow
		// the form to reset
		return true;
	}

	// Prevents the form from resetting
	e.preventDefault();

	// When using onReset="resetForm()" in markup, returning false would prevent
	// the form from resetting
	return false;
}


/*
 * Does all the error checking for the form.
 *
 * return   True if an error was found; False if no errors were found
 */

function formHasErrors(){

	// Code below here
	let errorFlag = false; // 假设是没错的,然后验证,如果true,说明就有错误了

	// 首先验证 textbox 不是空的
	let requiredFields = ["fname","lname","studentnum"]; //grasp ids

	for(let i = 0; i < requiredFields.length; i++){
		//遍历所有的必填字段 
		let textField = document.getElementById(requiredFields[i]);
		//如果有一个字段是空值 
		if(!formFieldHasInput(textField)){    
			//显示错误信息
			document.getElementById(requiredFields[i] + "_error").style.display = "block";
			
			if(!errorFlag){ //如果没有错误
	    textField.focus();  //设置焦点
	    textField.select(); //选中文本
	    }   
		//raise the error flag
		errorFlag = true; //有错误
		}
	}
		// \d+ 一个或多个数字
		// \w+ 一个或多个字母
		// \s+ 一个或多个空格
		/// ^\d +$/ 以数字开头,以数字结尾
   let regex = new RegExp(/^\d{6}$/);
	 let studentNumValue = document.getElementById("studentnum").value;

	 if(!regex.test(studentNumValue)){ //如果学号不是6位数字
		document.getElementById("studentnum_error").style.display = "block";
			if(!errorFlag){  //如果没有错误
				// textField.focus();
				// textField.select();
				document.getElementById("studentnum").focus();
				document.getElementById("studentnum").select();
			}
			//raise the error flag
			errorFlag = true;
	 }
	
	 //check if the user has selected a program
	 let program = ["bit","aviation","accounting","ba"];
	 let programChecked = false; 
	 for(let i = 0; i < program.length && !programChecked; i++){
		 if(document.getElementById(program[i]).checked){
			 programChecked = true;
		 }
	 }
	 if(!programChecked){
		 document.getElementById("program_error").style.display = "block";
		 
		 errorFlag = true;
	 }


	 let programMajor =["bit","ba"];   

	 for(let i = 0; i < programMajor.length; i++){
		 if(document.getElementById(programMajor[i]).checked &&
		 !formFieldHasInput(document.getElementById(programMajor[i] + "major"))) 
		 //display the error message
		 document.getElementById(programMajor[i] + "major_error").style.display = "block";
		 
		 if(!errorFlag){
			 document.getElementById(programMajor[i] + "major").focus();
		 }

		 errorFlag = true;
	}
	// Code above here
   	return errorFlag; 
}

/*
 * Resets (hides) all of the error messages on the page.
 */
function hideAllErrors() {
	// Code below here
	let errorFileds = document.getElementsByClassName("error");

	for (let i = 0; i < errorFileds.length; i++) { 
		errorFileds[i].style.display = "none"; //hide all error fields
	}
	 
}

/*
 * Handles the onclick event for program radio buttons for programs  
 * that have a major. 
 *
 * param  major  The id of the radio button that was clicked //单选按钮的id
 */
function showMajor(major) {  //major 是单选按钮的id
	//首先显示标题
	document.getElementById("majorheading").style.display = "block"; //

  document.getElementById(
		//如果major是bit,那么就隐藏ba major 
		((major == "bit") ? "ba" : "bit" )+ "majordiv").style.display = "none"; //隐藏另一个专业的文本字段输入
	document.getElementById(major + "majordiv").style.display = "block";//显示当前专业的文本字段输入
	document.getElementById(major + "major").value = ""; //清空文本字段的值
	document.getElementById(major + "major").focus(); //设置焦点let
		}


/*
 * Hides elements in the Major Information section of the page
 */
function hideMajor() {
	// Hide the heading in the major section
	document.getElementById("majorheading").style.display = "none";
	// Hide the text field input for both majors 隐藏两个专业的文本字段输入
	document.getElementById("bitmajordiv").style.display = "none";
	document.getElementById("bamajordiv").style.display = "none";
}

//去除字符串两边的空格 remove the space in the beginning and the end of the string
function trim(str) { 
	// uses a regex to remove spaces from the beginning and end of the string
	return str.replace(/^\s+|\s+$/g,"");  //去除字符串两边的空格
}


/*
 * Determines if a text field element has input
 *
 * param   fieldElement A text field input element object
 * return  True if the field contains input; False if nothing entered
 */
function formFieldHasInput(fieldElement) {
	// Check if the text field has a value
	if (fieldElement.value == null || trim(fieldElement.value) == "") {
		// Invalid entry
		return false;
	}
	// Valid entry
	return true;
}

/**
 * Handles the load event of the document.
 */
function load() {
	// Add event listener for the form submit event
	// submint 和 click button 不一样    
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
	
	// Add event listeners for the text fields in the major section 
	// 在专业部分添加文本字段的事件侦听器
	document.getElementById("aviation").addEventListener("click",hideMajor);
	document.getElementById("accounting").addEventListener("click",hideMajor);

}  

// Add the event listener for the document load 
// set up page
document.addEventListener("DOMContentLoaded", load);
