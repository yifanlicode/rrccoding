/*******f************
		Competency 13
    Name: Yifan Li
    Date:  2022-11-03
    Description: Competency 13 Event Listeners

********************/

//Task 1: Event listener to trigger the load function upon DOM loading

document.addEventListener( "DOMContentLoaded", load); 


/*	
	Task 2
	Load function
	Event listeners to setup the page will go here
*/

function load(){
	//grab the button
	let clickButton = document.getElementById("button");
	//add event listener 
	clickButton.addEventListener("click", clickMe);
}

/*
	Task 3
	Click Function
	This will change the display value of the input
*/


function clickMe(){

		let input = document.getElementById("popup");

		if(input.style.display !== "block"){
			input.style.display = "block";
		}
		else{
			input.style.display = "none";
		}

}


