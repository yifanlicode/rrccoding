/*******f************

    Competency 17
	Name: Yifan LI
	Date:2022-12-01
	Description: Competency 17 Using JSON to Create HTML

********************/

//adds an event listener to execute onLoad method when page finished loading
document.addEventListener("DOMContentLoaded", load);



/*
    createZooland function
    This function will retrieve the data for the animal you created specifically
    You will then add the code required to meet the specifications
 */
function createZooland(zoolandData) {
   

    let penguin = Object.values(zoolandData[0]);
    let penguinDiv = document.getElementById("content");
    let penguinName = document.createElement("h2");
    let penguinScientificName = document.createElement("h3");
    let penguinDescription = document.createElement("blockquote");

    
    penguinName.innerHTML = penguin[0];
    penguinScientificName.innerHTML = penguin[1];
    penguinDescription.innerHTML = penguin[2];

    penguinDiv.appendChild(penguinName);
    penguinDiv.appendChild(penguinScientificName);
    penguinDiv.appendChild(penguinDescription);
  
    let penguinImages = Object.values(penguin[3])[0]; 
    let penguinImagesArray = Object.values(penguinImages);
  
    // console.log(penguinImagesArray); check the array
    for (let i = 0; i < penguinImagesArray.length; i++) {
        let penguinImage = document.createElement("img");
        penguinImage.src = `images/${penguinImagesArray[i]}`;
        penguinDiv.appendChild(penguinImage);
    }
}



/*
    load function
        loading the json file - run when the page loads
 */
        function load() {
            fetch('zooland.json')
                .then(result => {
                    return result.json()
                })
                .then(data => {
                    createZooland(data);
                });
        }