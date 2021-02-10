window.addEventListener("DOMContentLoaded", (event) => {
    const category = document.getElementsByName("category");

    fetch('http://localhost:8080/tags', {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Access-Control-Allow-Origin':'*'
        }
    }).then(response => response.json()).then(data => {
        for(i=0; i<data.length; i++){
            categories.innerHTML += `
            <div class="category-link" id="${data[i]["tagName"]}" name="category" data-value="${data[i]["id"]}">${data[i]["tagName"]}</div>
            `;
        }
        const categoriesList = Array.from(category);

        for(i=0; i<categoriesList.length; i++){

            let id = categoriesList[i].getAttribute("data-value");
            let tagName = categoriesList[i].getAttribute("id");

            console.log(tagName)

            categoriesList[i].addEventListener("click", function(){

                fetch("http://localhost:8080/tags/"+id, {
                    method: 'GET',
                    mode: 'cors',
                    headers: {
                        'Access-Control-Allow-Origin':'*'
                    }
                }).then(response => response.json()).then(data => {

                    const title = document.getElementById("title");
                    const newTitle = document.createElement('h1');

                    newTitle.setAttribute("id", "title");
                    newTitle.innerHTML = tagName + " Recipes:";

                    title.parentNode.replaceChild(newTitle, title);

                    
                    const listItem = document.getElementById("categories");
                    const recipes = document.createElement('div');

                    recipes.className = "content";

                    for(i=0; i<data.length; i++){
                        recipes.innerHTML += `
                        <div class="category-link" name="recipe" data-value="${data[i]["id"]}">${data[i]["recipeName"]}</div>
                        `;
                    }

                    listItem.parentNode.replaceChild(recipes, listItem);
                }) 
            });
        }
    });
});