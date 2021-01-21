package TeamMcDev.project.Controllers;

import TeamMcDev.project.Models.Recipe;
import TeamMcDev.project.Models.data.IngredientRepository;
import TeamMcDev.project.Models.data.RecipeRepository;
import TeamMcDev.project.Models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping()
    public List<Recipe> displayAllRecipes(){
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();

        return recipes;
    }

    @PostMapping(value = "add")
    public ResponseEntity<Object> addRecipe(@RequestBody Recipe recipe){

        System.out.println(recipe);


        return ResponseEntity.status(201).build();
    }
}
