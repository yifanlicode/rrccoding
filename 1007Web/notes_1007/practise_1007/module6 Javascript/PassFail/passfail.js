/*
	Pass/Fail Demonstration 
	Nov 3, 2022
	Yifan Li
*/



//load the event listeners when the page loads 
//加载页面时加载事件监听器
function load(){

	//check the local storage for data 检查本地存储中的数据
	//if there is data, load it 如果有数据，加载它
	//if there is no data, do nothing 如果没有数据，什么也不做
	//getItem() 方法可获得 localStorage 对象中保存的指定项的值。
	if(localStorage.getItem("marksData")){
			let list = document.getElementsByTagName("marksList");
			list.innerHTML = localStorage.getItem("marksData");

			//Show the clear button 显示清除按钮
			clearButton.style.display = "block";
			//clearButton.style.display = "block"; //显示清除按钮

	} 

		//grab the button
		let submit = document.getElementById("submit"); //获取按钮
		//add an event listener 
		submit.addEventListener("click", checkData);//添加事件监听器

		let clear = document.getElementById("clearbutton");
		clear.addEventListener("click", clearButton);


}

function checkData(){  
	//	Validate the data 验证数据 
	//Retrieve the data from the DOM 从 DOM 中检索数据
			let name = document.getElementById("name").value; //获取姓名
			let mark = document.getElementById("mark").value; //获取分数
	
		//isNaN() 函数用于判断其参数是否是非数字值。
		//Javasceipt中的isNAN: 会把一个空的string转换成0，所以要用isNaN()来判断
		//parseInt() 函数来转换字符串为数字
		mark = parseInt(mark);
			if(name != "" && isNaN(mark)==false){ //如果姓名不为空并且分数是数字
				displayData(name,mark); //调用displayData函数
			}

			resetFields(); //重置表单
	
	}

	function displayData(name,mark){ //显示数据
		//	Declare variables 
			let passFail ="pass";//声明变量
	
			// 用 DOM 来创建一个新的表格行 
			let newTr = document.createElement("tr");
			let newNameTd = document.createElement("td");
			let newMarkTd = document.createElement("td");
			let newPassFailTd = document.createElement("td");
	
			if(mark < 50){ //如果分数小于50
				passFail = "fail"; //fail
			}
	
		//Add the data to the table cells 为表格单元格添加数据
		//innerHTML 属性设置或返回表格行的开始和结束标签之间的 HTML。
			newNameTd.innerHTML = name; //姓名
			newMarkTd.innerHTML = mark; //分数
			newPassFailTd.innerHTML = passFail; //pass or fail
			newTr.appendChild(newNameTd); //添加姓名
			newTr.appendChild(newMarkTd);//添加分数
			newTr.appendChild(newPassFailTd);//添加pass or fail
	
		//append the new row to the table body 为表格主体添加新行
		//获取表格主体 [0] 代表第一个表格主体 
			document.getElementsByTagName("tbody")[0].appendChild(newTr);
		//Show the clear button 显示清除按钮 
			clearButton.style.display = "block";
		

		//Save the data to local storage 将数据保存到本地存储
		saveListData();
	}
	
	
//	Clears the data in the form and hides the clear button
//清除表单中的数据并隐藏清除按钮
function clearButton(){
	let tbody = document.getElementsByTagName("tbody")[0];
	while(tbody.firstChild){
		tbody.removeChild(tbody.firstChild);
	}

	//Hide the clear button 隐藏清除按钮
	clearButton.style.display = "none";
	resetFields();

}




//	Resets the form's inputs to their default values
//  重置表单的输入值为默认值
function resetFields(){
	document.getElementById("name").value = "";
	document.getElementById("mark").value = "";
	document.getElementById("name").focus();
	saveListData();
}




//	Save the list data to local storage 保存列表数据到本地存储
function saveListData(){
	//grab the list  
	let list = document.getElementsByTagName("tbody")[0];
	//保存表格主体的内容
	localStorage.setItem("marksData",list.innerHTML); 
}

  
document.addEventListener("DOMContentLoaded", load);

