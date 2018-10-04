/**
 * 1. API's that I will be using:
 *      - Open Weather Map <-- works apiKey: 755554f6d1329c581e0d5946da26b9dc
 *          ~NOT able to extract data at all
 *      - Open Brewery <-- works for sure. I can extract data w/out trouble
 *      - Open Table HerokU App <-- works
 *          ~NOt able to extract dat at all
 *      - 
 * 
 * 2. Pages are going to be linked to each other w/ an anchor tag
 * 
 * 3. Going to have dropdown options to choose help JS decide how to receive
 *      input from a user.
 * 
 * 4. A submit button that will send a request to the API
 * 
 * NOTE: 
 * - Geolocation api, can't find the url I'm supposed to use, and the username isn't
 *      working :(
 * - I need to find an API for traffic
 * 
 */

//-------------Below works------------------------------------------------
let presentWeather;
let presentBreweries;
let presentRestaurants;

const getWeather = async function(){
    let response = await fetch('https://api.openweathermap.org/data/2.5/weather?zip=78721&APPID=755554f6d1329c581e0d5946da26b9dc');
    presentWeather = await response.json()
    console.log(presentWeather);
}


async function getBreweries(){
    let response = await fetch('https://api.openbrewerydb.org/breweries?by_city=Austin&by_state=Texas');
    let presentBreweries = await response.json();
    console.log(presentBreweries);
 }


const getRestaurants = async function(){
    let response = await fetch('https://opentable.herokuapp.com/api/restaurants?city=Dallas&state=TX');
    presentRestaurants = await response.json();
    console.log(presentRestaurants.restaurants);
}

getRestaurants();
getWeather();
getBreweries();
//-------------Above works-------------------------------------------------


// let presentCostOfLiving;
// const getCostOfLivingUsingAsync = async function(){
//     let response = await fetch('https://apps.bea.gov/api/data/?&UserID=F7F1494A-928C-4B8E-893F-079D17AF84CC&method=getparameterlist&datasetname=RegionalProduct&ResultFormat=JSON');
//     let presentCostOfLiving = await response.json();
//     console.log(presentCostOfLiving);
// }
// getCostOfLivingUsingAsync();


