window.addEventListener("DOMContentLoaded", (event) => {
    const recipeName = document.getElementById("recipeName");
    const directions = document.getElementById("directions");
    const ingredients = document.getElementById("ingredients");
    const tags = document.getElementById("tags")
    const submit = document.getElementById("submit")

    fetch('http://localhost:8080/ingredients', {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Access-Control-Allow-Origin':'*'
        }
    }).then(response => response.json()).then(data => {
        for(i=0; i<data.length; i++){
            ingredients.innerHTML += `
            <input type="checkbox" id="ingredient" name="${data[i]["ingredientName"]}" value="${data[i]}">
            <label for="${data[i]["ingredientName"]}">${data[i]["ingredientName"]}</label>
            `;
        }
    });
    fetch('http://localhost:8080/tags', {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Access-Control-Allow-Origin':'*'
        }
    }).then(response => response.json()).then(data => {
        for(i=0; i<data.length; i++){
            tags.innerHTML += `
            <input type="checkbox" id="tag" name="${data[i]["tagName"]}" value="${data[i]}">
            <label for="${data[i]["tagName"]}">${data[i]["tagName"]}</label>
            `;
        }
    });

    submit.addEventListener("click", function() {
        fetch('http://localhost:8080/recipes/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(recipeName, directions, ingredients, tags) // body data type must match "Content-Type" header
        })
        // Once it gets the data it formats it as JSON
        // Takes in the API response and returns the data
        .then(response => response.json())
        // This takes in the data that was returned from the line above
        // Now that we have the data, we can do cool stuff with it:
        .then(data => {
        // If you want to do something with the response data, you can here
        });
    });
});
