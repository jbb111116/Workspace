let returned;
let address;
const submitE = document.getElementById('submit-btn');

function getInput(){
    let input = document.getElementById('input1');
    address = input.value;
    restInputs(address);

}

function restInputs(address){
    // Make sure the address is a string.
    if (typeof address !== "string") throw "Address is not a string.";
    
    // Trim the address.
    address = address.trim();
    
    // Make an object to contain the data.
    returned = {};
    
    // Find the comma and pull out the city
    let comma = address.indexOf(',');
    returned.city = address.slice(0, comma);

    // Get everything after the city.
    // The string after the comma, +2 so that we skip the comma and the space.
    let after = address.substring(comma + 2); 
    
    // Pull out the state.
    returned.state = after;
    

    console.log(returned);
    // Return the data.
    return returned;
}


submitE.addEventListener('click',getInput);