/********f***********
    
	Project 3 Javascript
	Name: Yifan Li
	Date: 2022.11.17
	Updated: 2022.11.25
	Description: Form Validation


********************/


const itemDescription = ["MacBook", "The Razer", "WD My Passport", "Nexus 7", "DD-45 Drums"];
const itemPrice = [1899.99, 79.99, 179.99, 249.99, 119.99];
const itemImage = ["mac.png", "mouse.png", "wdehd.png", "nexus.png", "drums.png"];
let numberOfItemsInCart = 0;
let orderTotal = 0; 

/*
 * Handles the submit event of the survey form
 *
 * param e  A reference to the event object
 * return   True if no validation errors; False if the form has
 *          validation errors
 */

function validate(e) {
	// Hides all error elements on the page
	hideErrors();

	// Determine if the form has errors
	if (formHasErrors()) {
		// Prevents the form from submitting
		e.preventDefault();
		// When using onSubmit="validate()" in markup,
		//returning false would prevent the form from submitting
		return false;
	}
	// When using onSubmit="validate()" in markup, returning true would allow
	// the form to submit
	return true;
}


/*
 * Handles the reset event for the form.
 *
 * param e  A reference to the event object
 * return   True allows the reset to happen; False prevents
 *          the browser from resetting the form.
 */
function resetForm(e) {
	// Confirm that the user wants to reset the form.
	if (confirm('Clear order?')) {
		// Ensure all error fields are hidden
		hideErrors();
		// Set focus to the first text field on the page
		document.getElementById("qty1").focus();
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
 * return  True if an error was found; False if no errors were found
 */


function formHasErrors() {

	let errorFlag = false;  

	// Determine if any items are in the cart
	// When the cart has not items, submission of form is halted
	if (numberOfItemsInCart == 0) {
		// Display an error message contained in a modal dialog element
		const modal = document.querySelector("#cartError");
		modal.showModal();

		const closeModal = document.querySelector(".close-button");
		closeModal.addEventListener("click", () => {
			modal.close();
			document.getElementById("qty1").focus();
		});
		// Form has errors
		errorFlag = true;
		
	}

	//Complete the validations below
	//Shipping Information Validation

	let requiredFields = ["fullname", "address", "city","province", "postal", "email"];
	for (let i = 0; i < requiredFields.length; i++) {
		let currentField = document.getElementById(requiredFields[i]);
		if (!formFieldHasInput(currentField)) {
			document.getElementById(requiredFields[i] + "_error").style.display = "block";
			if(!errorFlag){ //if there is no error
				currentField.focus(); //set focus to the first error field
				currentField.select(); //select the text in the field
			}
			errorFlag = true;
		}

		 //use regex to check if the email is valid 
		let emailValue = document.getElementById("email");
		let emailRegex = new RegExp(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/);
		if(!emailRegex.test(emailValue.value) && formFieldHasInput(emailValue)){
			document.getElementById("emailformat_error").style.display = "block";
			if(!errorFlag){
				emailValue.focus();
				emailValue.select();
			}
			errorFlag = true;
		}

			//use regex to check if the postal code is valid 
	  let postalCode = document.getElementById("postal");
		let postalRegex = new RegExp(/^[A-Za-z]\d[A-Za-z][ -]?\d[A-Za-z]\d$/);

		if(!postalRegex.test(postalCode.value) && formFieldHasInput(postalCode)){
			document.getElementById("postalformat_error").style.display = "block";

			if(!errorFlag){
				postalCode.focus();
				postalCode.select();
			}
			errorFlag = true;
		}


		 //Payment Information Validation
     //card type: required selected one
     let cardType = ["visa", "mastercard", "amex"];
		 let cardTypeFlag = false;
		 for(let i = 0; i < cardType.length && !cardTypeFlag; i++){
			 if(document.getElementById(cardType[i]).checked){
				 cardTypeFlag = true;
			 }
			}
			 if(!cardTypeFlag){
				 document.getElementById("cardtype_error").style.display = "block";
				 errorFlag = true;
				}

		 //check cardinformation is not empty
	    // card name, card number
			let cardInfo = ["cardname", "year","cardnumber"];
			for(let i = 0; i < cardInfo.length; i++){
				let currentField = document.getElementById(cardInfo[i]);
				if(currentField.value == ""){
					document.getElementById(cardInfo[i] + "_error").style.display = "block";
					if(!errorFlag){
						currentField.focus();
						currentField.select();
					}
					errorFlag = true;
				}

			}

			//must choose one of the expiry date month from the list
			let expiryMonth = document.getElementById("month");
			if(expiryMonth.selectedIndex == 0){ 
				document.getElementById("month_error").style.display = "block";
				if(!errorFlag){
					expiryMonth.focus();
				}
				errorFlag = true;
			}


			let expiryYear = document.getElementById("year").value; 
			let currentMonth = new Date().getMonth() + 1; //getMonth() returns 0-11
			let currentYear = new Date().getFullYear(); 
			//if the year < current year, or the year = current year and month < current month ,error
			if((expiryYear < currentYear || (expiryYear == currentYear && expiryMonth.selectedIndex < currentMonth)) 
			   && expiryMonth.selectedIndex != 0){
				document.getElementById("expiry_error").style.display = "block";
				if(!errorFlag){
					expiryMonth.focus();
				}
				errorFlag = true;
			}

      // check the card number is valid
			let cardNumber = document.getElementById("cardnumber");

			if (!validCardNum(cardNumber.value) && formFieldHasInput(cardNumber)) {
				document.getElementById("invalidcard_error").style.display = "block";
				if(!errorFlag){
					cardNumber.focus();
					cardNumber.select();
				}
				errorFlag = true;

			}
			
  }
	    return errorFlag;

}

/*
 * This function checks card number is valid or not
 *
 * param  cardNumber the card number to be checked  
 * return true if the card number is valid, false otherwise
 */
function validCardNum(cardnum) {

	// pass the 10 digits card number to the function
	let regex = new RegExp(/^\d{10}$/); 
	if (!regex.test(cardnum)) { //if the card number is not 10 digits
		return false; //return false
	}

	// use check factor to check if the card number is valid
	let checkFactors = [4, 3, 2, 7, 6, 5, 4, 3, 2];
	let sum = 0;
	for (let i = 0; i < 9; i++) { //loop through the first 9 digits
		//multiply each digit by the check factor
		sum += parseInt(cardnum.charAt(i)) * checkFactors[i]; 
	}

	//get the check digit 
	let checkDigit = 11 - (sum % 11);
	//return true if the check digit is valid
	return cardnum[9] == checkDigit; 
}


/*
 * Adds an item to the cart and hides the quantity and add button for the product being ordered.
 *
 * param itemNumber The number used in the id of the quantity, item and remove button elements.
 */
function addItemToCart(itemNumber) {
	// Get the value of the quantity field for the add button that was clicked 
	let quantityValue = trim(document.getElementById("qty" + itemNumber).value);

	// Determine if the quantity value is valid
	if (!isNaN(quantityValue) && quantityValue != "" && quantityValue != null && quantityValue != 0 && !document.getElementById("cartItem" + itemNumber)) {
		// Hide the parent of the quantity field being evaluated
		document.getElementById("qty" + itemNumber).parentNode.style.visibility = "hidden";

		// Determine if there are no items in the car
		if (numberOfItemsInCart == 0) {
			// Hide the no items in cart list item 
			document.getElementById("noItems").style.display = "none";
		}

		// Create the image for the cart item
		let cartItemImage = document.createElement("img");
		cartItemImage.src = "images/" + itemImage[itemNumber - 1];
		cartItemImage.alt = itemDescription[itemNumber - 1];

		// Create the span element containing the item description
		let cartItemDescription = document.createElement("span");
		cartItemDescription.innerHTML = itemDescription[itemNumber - 1];

		// Create the span element containing the quanitity to order
		let cartItemQuanity = document.createElement("span");
		cartItemQuanity.innerHTML = quantityValue;

		// Calculate the subtotal of the item ordered
		let itemTotal = quantityValue * itemPrice[itemNumber - 1];

		// Create the span element containing the subtotal of the item ordered
		let cartItemTotal = document.createElement("span");
		cartItemTotal.innerHTML = formatCurrency(itemTotal);

		// Create the remove button for the cart item
		let cartItemRemoveButton = document.createElement("button");
		cartItemRemoveButton.setAttribute("id", "removeItem" + itemNumber);
		cartItemRemoveButton.setAttribute("type", "button");
		cartItemRemoveButton.innerHTML = "Remove";
		cartItemRemoveButton.addEventListener("click",
			// Annonymous function for the click event of a cart item remove button
			function () {
				// Removes the buttons grandparent (li) from the cart list
				this.parentNode.parentNode.removeChild(this.parentNode);

				// Deteremine the quantity field id for the item being removed from the cart by
				// getting the number at the end of the remove button's id
				let itemQuantityFieldId = "qty" + this.id.charAt(this.id.length - 1);

				// Get a reference to quanitity field of the item being removed form the cart
				let itemQuantityField = document.getElementById(itemQuantityFieldId);

				// Set the visibility of the quantity field's parent (div) to visible
				itemQuantityField.parentNode.style.visibility = "visible";

				// Initialize the quantity field value
				itemQuantityField.value = "";

				// Decrement the number of items in the cart
				numberOfItemsInCart--;

				// Decrement the order total
				orderTotal -= itemTotal;

				// Update the total purchase in the cart
				document.getElementById("cartTotal").innerHTML = formatCurrency(orderTotal);

				// Determine if there are no items in the car
				if (numberOfItemsInCart == 0) {
					// Show the no items in cart list item 
					document.getElementById("noItems").style.display = "block";
				}
			},
			false // End of the annonymous function for the click event of a cart item remove button
		);

		// Create a div used to clear the floats
		let cartClearDiv = document.createElement("div");
		cartClearDiv.setAttribute("class", "clear");

		// Create the paragraph which contains the cart item summary elements
		let cartItemParagraph = document.createElement("p");
		cartItemParagraph.appendChild(cartItemImage);
		cartItemParagraph.appendChild(cartItemDescription);
		cartItemParagraph.appendChild(document.createElement("br"));
		cartItemParagraph.appendChild(document.createTextNode("Quantity: "));
		cartItemParagraph.appendChild(cartItemQuanity);
		cartItemParagraph.appendChild(document.createElement("br"));
		cartItemParagraph.appendChild(document.createTextNode("Total: "));
		cartItemParagraph.appendChild(cartItemTotal);

		// Create the cart list item and add the elements within it
		let cartItem = document.createElement("li");
		cartItem.setAttribute("id", "cartItem" + itemNumber);
		cartItem.appendChild(cartItemParagraph);
		cartItem.appendChild(cartItemRemoveButton);
		cartItem.appendChild(cartClearDiv);

		// Add the cart list item to the top of the list
		let cart = document.getElementById("cart");
		cart.insertBefore(cartItem, cart.childNodes[0]);

		// Increment the number of items in the cart
		numberOfItemsInCart++;

		// Increment the total purchase amount
		orderTotal += itemTotal;

		// Update the total puchase amount in the cart
		document.getElementById("cartTotal").innerHTML = formatCurrency(orderTotal);
	}
}


/*
 * Determines if a text field element has input
 *
 * param   element The text field element to evaluate
 * return  True if the field contains input; otherwise, false
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


/*
 * Hides all of the error elements.
 */
function hideErrors() {
	// Get an array of error elements
	let error = document.getElementsByClassName("error");

	// Loop through each element in the error array
	for (let i = 0; i < error.length; i++) {
		// Hide the error element by setting it's display style to "none"
		error[i].style.display = "none";
	}
}

/*
 * Handles the load event of the document.
 */

function load() {
	//	Populate the year select with up to date values
	let year = document.getElementById("year");
	let currentDate = new Date();
	for (let i = 0; i < 7; i++) {
		let newYearOption = document.createElement("option");
		newYearOption.value = currentDate.getFullYear() + i;
		newYearOption.innerHTML = currentDate.getFullYear() + i;
		year.appendChild(newYearOption);
	}

	// Add event listener for the form submit event

	document.getElementById("orderform").addEventListener("submit", validate);

	//create event listener for the reset event
	//the reset button should trigger the resetform() function

	document.getElementById("orderform").addEventListener("reset", resetForm);




	//Write event listeners for each of add button 
	// call a function called addItemToCart() and pass value
	document.getElementById("addMac").addEventListener("click", function () {
		addItemToCart(1);
	});
	document.getElementById("addMouse").addEventListener("click", function(){
		addItemToCart(2);
	});
	document.getElementById("addWD").addEventListener("click", function(){
		addItemToCart(3);
	});
	document.getElementById("addNexus").addEventListener("click", function(){
		addItemToCart(4);
	});
	document.getElementById("addDrums").addEventListener("click",function(){
		addItemToCart(5);
	});

	//When the function loads, call a function called hideErrors() that will hide all the error messages. 
	hideErrors();
	}
// Add document load event listener
document.addEventListener("DOMContentLoaded", load);




