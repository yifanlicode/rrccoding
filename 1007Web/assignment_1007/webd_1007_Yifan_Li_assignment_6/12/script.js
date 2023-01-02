/*******f************

    Competency 12 Javascript Syntax
    Name: Yifan li
    Date: 2022-11-02
    Description:  JavaScript Syntax
	
********************/


//create an array with 5 of your favourite quotes.
let favQuotes = ["Practice makes perfect.",
                "That which does not kill us makes us stronger.",
                "I think, therefore I am.",
                "The only thing we have to fear is fear itself.",
                "A man is but what he knows."];



//add each array element within a new <p> tag

for (let i = 0; i < favQuotes.length; i++) {
    let quote = favQuotes[i];
    document.body.innerHTML += `<p>${quote}</p>`;
}





