let content= document.getElementById("content");


function getJokes(){
    // This starts by going to the API to get the data:
    fetch('http://localhost:8080/greeting')
        // Once it gets the data it formats it as JSON
        // Takes in the API response and returns the data
        .then(response => response.json())
        // This takes in the data that was returned from the line above
        // Now that we have the data, we can do cool stuff with it:
        .then(data => {
        // Do stuff with the data:
        content.innerText=data.content;
        console.log(data);
        })
  }
  getJokes();
