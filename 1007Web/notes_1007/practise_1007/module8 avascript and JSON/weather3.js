/*
	weather.js
	Load the weather.json file
	Grab the relevant values from the JSON and create HTML 
	DOM elements that will display the information.

	Alan Simpson
	10.30.2022
*/


//	Add the event listener to run when the page is loaded
document.addEventListener("DOMContentLoaded", load);


// const load = () => {
// 	fetch('weather.json')
// 		.then(result => {
// 			return result.json();
// 		})
// 		.then(data => {
// 			createWeather(data);
// 		});
// }


function load(){
		fetch('weather.json')
		.then(function(result){
			return result.json();
		})
		.then(function(data){
			createWeather(data);
		});
}


//	Loop through the cities in the JSON
//	Build a section, h1, ul and lis for each city
// const createWeather = (weatherData) => {
// 	console.table(weatherData)
// }

function createWeather(weatherData){
	let body = document.getElementsByTagName("body")[0]; //
	let div = document.getElementsByTagName("div")[0]; // get the div element

	// loop through the cities in the JSON
	for(let i = 0; i < weatherData.length; i++){
		//retrieve and create a generic list of keys and values
		let keys = Object.keys(weatherData[i]);
		let values = Object.values(weatherData[i]);

		let section = document.createElement("section");
		let h1 = document.createElement("h1");
		let ul = document.createElement("ul");

		h1.innerHTML = `${weatherData[i].name} Weather`;// set the h1 to the city name
		section.appendChild(h1); // add the h1 to the section
		section.appendChild(ul); // add the ul to the section
		body.insertBefore(section,div); // add the section to the body

	for(let j=0;j<keys.length;j++){
		let li = document.createElement("li");
		let label = document.createElement("label");
		let span = document.createElement("span");

		label.innerHTML = `${keys[j]}`;
		span.innerHTML = `${values[j]}`;
		if(keys[j] == "temperature"){
			span.innerHTML += "&deg;C";
		}

		li.appendChild(label);
		li.appendChild(span);
		ul.appendChild(li);
	}

	}

};

















