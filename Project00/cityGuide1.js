// let 

//     fetch(weatherUrl)
//         .then((response)=>{
    //             console.log(response);
    //             return response.json();
    //         })
    
    //         .then((data)=> {
        //             state = data[0];
        //             console.log(state);
        //         })
        
        //         .catch((error)=> {
            //             alert('oh naw');
            //             console.log(error);
//         });
// }

// getWeatherData();
// getWeather();



const getWeatherData = function(){
    const weatherUrl = 'https://api.openweathermap.org/data/2.5/weather?zip=78721&APPID=755554f6d1329c581e0d5946da26b9dc';
    fetch(weatherUrl)
    .then(function(response){
            return response.json();
        })
        .then(function(data){
                let output = '<h2>Weather</h2>';
                data.weather.forEach(function(user){
                        output +=`
                        <ul>
                            <li>Coord: ${user.clouds}</li>
                            <li>Weather: ${user.coord}</li>
                            <li>Base: ${user.main}</li>
                            <li>Main: ${user.rain}</li>
                            <li>Main: ${user.weather}</li>
                        </ul>
                        `;
                });
                document.getElementById('output1').innerHTML = output;
            }
            //Same as above, but w/ pointers
// This works--->vvvvvv----------------------------------------------------
function getBreweries(){
    const beerUrl = 'https://api.openbrewerydb.org/breweries?by_city=Austin&by_state=Texas';
    fetch(beerUrl)
    .then((response)=>response.json())
    .then((data)=>{
        // This presents the data in the HTML Doc
        let output1 = '<h2>Breweries</h2>';  
        data.forEach(function(brew){
            output1 += `
            <ul>
                <li>ID: ${brew.id}</li>
                <li>Name: ${brew.name}</li>
                <li>Brewery type: ${brew.brewery_type}</li>
                <li>Street: ${brew.street}</li>
                <li>City: ${brew.city}</li>
            </ul>
            `;
        });
        document.getElementById('output1').innerHTML = output1;
    })
}

document.getElementById('getBreweries').addEventListener('click',getBreweries);
// This works---->^^^^^^---------------------------------------------------------

function getRestaurants(){
    const restUrl ='https://opentable.herokuapp.com/api/restaurants?city=Dallas&state=TX';
    fetch(restUrl)
    .then((response)=> response.json())
    .then((data) => {
        let output2 = '<h2>Restaurants</h2>';
        data.restaurants.forEach(function(rest){
            output2 +=`
            <ul>
                <li>Name: ${rest}</li>
            </ul>
            `;
        });
        document.getElementById('output2').innerHTML = output2;
    })
}

document.getElementById('getRestaurants').addEventListener('click',getRestaurants);

