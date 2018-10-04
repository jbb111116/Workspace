//------------------------- Brewery Data Retrieval and Display --------------------------------------------


function getBrewInput(){
    let input = document.getElementById('brewInput');
    address = input.value;
    brewInputs(address);
    
}
    /**
     * This function takes in the address from getBrewInput() function
     * and splits the entry into an object containing the two variables
     * city and state.
     * @param {*} address 
     */
function brewInputs(address){
    if(typeof address !== "string") throw "Address is not a string.";
    address = address.trim();
    let breweryLocation = {};
    let comma = address.indexOf(',');
    breweryLocation.city = address.slice(0,comma);
    let after = address.substring(comma +2);
    breweryLocation.state = after;
    console.log(breweryLocation);
    
    const url1 = 'https://api.openbrewerydb.org/breweries?by_city=';
    const input1 = breweryLocation.city;
    const url2 = '&by_state=';
    const input2 = breweryLocation.state;
    brewUrl = url1 + input1 + url2 + input2;
    
    getBreweries(brewUrl);
    
}
function getBreweries(brewUrl){
    // const brewUrl ='https://api.openbrewerydb.org/breweries?by_city=Austin&by_state=Texas';
    url = brewUrl;
    fetch(url)
    .then((response)=>response.json())
    .then((data)=>{
        let output = '';
        data.forEach(function(brew) {
            output += `
            <a href='${brew.website_url}'>
            <ul id='breweries'>
            <li>Name: ${brew.name}</li>
            <li>Brewery Type: ${brew.brewery_type}</li>
            <li>Street: ${brew.street}</li>
            <li>City: ${brew.city}, ${brew.state}</li>
            <li>Phone: ${brew.phone}</li>
            </ul>
            </a>
            `;
        });
        document.getElementById('output1').innerHTML = output;
    })
}
let submitBrewery = document.getElementById('submitBrewery');
document.getElementById('submitBrewery').addEventListener('click',getBrewInput);
//--------------------------------------------------------------------------------------------------------
