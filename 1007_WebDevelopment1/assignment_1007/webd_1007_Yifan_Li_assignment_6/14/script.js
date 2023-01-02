/*******f************

    Competency 14 
    Name: Yifan Li
    Date:  2022-11-03
    Description: Competency 14  Manipulating Elements
	

********************/

document.addEventListener("DOMContentLoaded", load);

/*	
    Load function
    Create, insert, and delete elements
*/

function load() {

    let newPara = document.createElement("p");
    newPara.innerHTML = "That's so cool!";
    let results = document.getElementById("results");
    results.appendChild(newPara);


    let newH2 = document.createElement("h2");
    newH2.innerHTML = "Create Insert Delete Elements By DOM";
    results.insertBefore(newH2, newPara); 

    //remove the <footer> element from the DOM
    let footer = document.getElementsByTagName("footer")[0];
    footer.parentNode.removeChild(footer);


}




