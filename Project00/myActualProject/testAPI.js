let address;
let url;
/**
 * Types of breweries:
 * - brewpub
 * - microbrewery
 * - planning
 * - regional
 * - contract
 * 
 * These have to pre-set on the webpage for breweries.
 * Top or bottom <-- look it up
 * 
 * Restaurant picture or picture of the city may be another feature i could add
 * Will need an api to extract pictures of a certain city
 */



//------------------------Restaurant Data Retrieval and Display -----------------------------------------
function getRestInput(){
    let input = document.getElementById('restInputs');
    address = input.value;
    restInputs(address);
    
}
    
function restInputs(address){
    // Make sure the address is a string.
    if (typeof address !== "string") throw "Address is not a string.";
    
    // Trim the address.
    address = address.trim();
    
    // Make an object to contain the data.
    let restaurantLocation = {};
    
    // Find the comma and pull out the city
    let comma = address.indexOf(',');
    restaurantLocation.city = address.slice(0, comma);
    
    // Get everything after the city.
    // The string after the comma, +2 so that we skip the comma and the space.
    let after = address.substring(comma + 2); 
    
    // Pull out the state.
    restaurantLocation.state = after;
    
    
    console.log(restaurantLocation);
    // Return the data.
    const url1 = 'https://opentable.herokuapp.com/api/restaurants?city='
    const input1 = restaurantLocation.city;
    const url2 = '&state=';
    const input2 = restaurantLocation.state;
    restUrl = url1 + input1 + url2 + input2;
    
    getRestaurants(restUrl);
}

function getRestaurants(restUrl){
    // const restUrl = 'https://opentable.herokuapp.com/api/restaurants?city=Houston&state=TX';
    url = restUrl;
    fetch(url)
    .then((response)=>response.json())
    .then((data)=>{
        let output = '';
        data.restaurants.forEach(function(rest){
            output +=`
            <a href='${rest.reserve_url}' id='rest'>
            <ul id='restaurants' style="background-image:url(${rest.image_url})">
                <li>Restaurant Name:       ${rest.name}</li>
                <li>Address:    ${rest.address}</li>
                <li>City:       ${rest.city}, ${rest.state}</li>
                <li>Zip:      ${rest.postal_code}</li>
                <li>Phone:      ${rest.phone}</li>
                </ul>
                </a>
            `;
        
        });
        document.getElementById('output2').innerHTML = output;
    })
}


// let submitRestaurant = document.getElementById('submitRestaurant');
document.getElementById('submitRestaurant').addEventListener('click',getRestInput);






// Below, code is conflicting
// document.getElementById('getRestaurants').addEventListener('click',getRestaurants);
//-----------------------------------------------------------------------------------------------------------
// let zip = $('#zip');
// let cityState = $('#city-state');
// document.getElementById('getBreweries').addEventListener('click',getBreweries);