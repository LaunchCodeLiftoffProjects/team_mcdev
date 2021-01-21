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
            <input type="checkbox" name="ingredient" value="${data[i]["ingredientName"]}">
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
            <input type="checkbox" name="tag" value="${data[i]["tagName"]}">
            <label for="${data[i]["tagName"]}">${data[i]["tagName"]}</label>
            `;
        }
    });

    submit.addEventListener("click", function() {
        const ingredientCheckboxes = document.getElementById("ingredients");
        const tagCheckboxes = document.getElementById("tags");
        const checkedIngredients = ingredientCheckboxes.getElementsByTagName("input");
        const checkedTags = tagCheckboxes.getElementsByTagName("input");


        let selectedIngredients = new Array();
        let selectedTags = new Array();
 
        for (var i = 0; i < checkedIngredients.length; i++) {
            if (checkedIngredients[i].checked) {
                selectedIngredients.push(checkedIngredients[i].value);
                console.log(checkedIngredients[i].value)
            }
        }

        for (var i = 0; i < checkedTags.length; i++) {
            if (checkedTags[i].checked) {
                selectedTags.push(checkedTags[i].value);
            }
        }

        var recipe = {
            recipeName: recipeName.value,
            directions: directions.value,
            ingredients: selectedIngredients,
            tags: selectedTags
        }

        fetch('http://localhost:8080/recipes/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(recipe) // body data type must match "Content-Type" header
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
