const getData = async function() {
    /**
     * Using Fetch
     */
    const prefixUrl = 'localhost:8080/';
    let searchUsername = document.getElementById('search-input-username').value;
    let searchPass = document.getElementById('search-input-pass').value;
    const suffixUrl;
    let url = prefixUrl + searchUsername + '/' +searchPass;


    const response = await fetch(url);
    const data = await response.json();
    console.log(data);


    for(let url of data.povCharacters){
        const charResponse = await fetch(url);
        const charData = await charResponse.json();
        const li = document.createElement('li');
        li.innerText = charData.name;
        document.getElementById('character-list').appendChild(li);
    }
}
getData();