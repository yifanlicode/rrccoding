/*******f************

  Competency 16
	Name: Yifan LI
	Date:2022-12-01
	Description: Competency 16 Traversing JSON

********************/

//adds an event listener to execute onLoad method when page finished loading
document.addEventListener("DOMContentLoaded", load);

/*
    Load function
    Using the fetch API, get your chosen dataset from the Dog API


 */
function load() {
    fetch("https://dog.ceo/api/breed/australian/images")
        .then(result => {
            return result.json();
        })
        .then(data => {
            createHTML(data); 
        });
        australian
}

/*
    createHTML function
    Using your chosen Dog dataset, create at least 2 HTML elements 
    and add them to the provided HTML
*/


function createHTML(Data) {
    
    let breedsObject = Data.message;
    let main = document.getElementById("wrapper");

    let subBreed = Object.keys (breedsObject);
    let imagesrc = Object.values(breedsObject);

    let h1 = document.createElement("h1");
    h1.innerHTML = `Dog breed: ${subBreed}`;
    main.appendChild(h1);

    for (let i = 0; i < imagesrc.length; i++) {
        let img = document.createElement("img");
        let h2 = document.createElement("h2");

        h2.innerHTML = `Random Dog Image From Australian Collection${i+1}`; 
        h2.style.fontSize = "20px";
        h2.style.color = "SkyBlue";
        h2.style.textAlign = "center";


        //do not forget to add the src attribute to the image element
        // img.src = "https://images.dog.ceo/breeds/terrier-irish/n02093991_1003.jpg";
        // img.setAttribute("src", imagesrc[i]);
        img.src = imagesrc[i];
        img.style.width = "300px";
        img.style.height = "300px";
        img.style.display = "block";
        img.style.margin = "auto";
        img.style.border = "5px solid SkyBlue";
        main.appendChild(h2);
        main.appendChild(img);
    }
}
   



    

  
       






        
 






    


