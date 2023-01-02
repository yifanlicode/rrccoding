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
    https://dog.ceo/api/breeds/list/all

 */
function load() {
    fetch("https://dog.ceo/api/breeds/list/all")   
        .then(result => {
            return result.json();
        })
        .then(data => {
            createHTML(data); 
        });

}

/*
    createHTML function
    Using your chosen Dog dataset, create at least 2 HTML elements 
    and add them to the provided HTML
*/


function createHTML(Data) {
    
    let main = document.getElementById("wrapper");


    //get the object of breeds
    const breedsObject = Data.message; 
    //get the array of breeds
    const breedsArray = Object.keys(breedsObject);
    //get the array of sub-breeds
    const subBreed = Object.values(breedsObject);               

    // choose the breeds "shiba"
    for (let i = 0; i <  breedsArray.length; i++) {
        if(breedsArray[i] == "shiba"){  
            let h1 = document.createElement("h1");
            h1.innerHTML = `Dog breed: ${breedsArray[i]}`;
            main.appendChild(h1);

            //if the subBreed is empty, show there is no subBreed
            if(subBreed[i].length == 0){
                let h2 = document.createElement("h2");
                h2.innerHTML = `It has no subBreed`;
                main.appendChild(h2);
            }else{
                for (let j = 0; j < subBreed[i].length; j++) {
                    let h2 = document.createElement("h2");
                    h2.innerHTML = `The ${[j+1]} subBreed is  ${subBreed[i][j]}`; 
                    main.appendChild(h2);
                }
            }

            //show the images of the breed "shiba"
            let img = document.createElement("img");
            //fetch the images from the API
            fetch(`https://dog.ceo/api/breed/shiba/images`)
                .then(result => {
                    return result.json();
                }
                )
                .then(data => {
                    let imagesrc = data.message;
                    for (let i = 0; i < imagesrc.length; i++) {
                        let img = document.createElement("img");
                        img.src = imagesrc[i];
                        main.appendChild(img);
                    }
                }   
                );
        }
    }
}   


    




        
 






    


