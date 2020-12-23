window.addEventListener("load", function() {

	const form = document.querySelector("#searchForm")

	const showResults = document.getElementById("results")

	form.addEventListener('submit', async function(e){
		e.preventDefault();
		const searchTerm = form.elements.query.value;
		const res = await axios.get(`https://api.spoonacular.com/recipes/complexSearch?apiKey=637856678d604835bc9ea4cf1333ea8a&addRecipeInformation=true&query=${searchTerm}`);
		displayRecipes(res.data);
	});

	const displayRecipes = (recipes) => {
        
		const i = recipes.results;
		for(let recipe of i){ 
			let steps = recipe.analyzedInstructions;
            showResults.innerHTML += `
            <div class = "col-xs-6 col-md-3">
                <div class="thumbnail">
                    <img src = ${recipe.image} alt = ${recipe.title}>
                    <div class="caption">
						<h3>${recipe.title}</h3>
						`
						for(let step of steps){
							let instrictions = step.steps;
							for(let instriction of instrictions){
								console.log(instriction.step);
								`<p>${instriction.step}</p>`
							}
						}                    
                        `<p><a href="#" class="btn btn-success" role="button">Save recipe</a> <a href="${recipe.sourceUrl}" class="btn btn-primary" role="button">Link to recipe</a></p>
                    </div>
                </div>    
            </div>`
		}
			
			
		
	}		
			
});