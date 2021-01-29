package TeamMcDev.project.Controllers;

import TeamMcDev.project.Models.Ingredient;
import TeamMcDev.project.Models.Recipe;
import TeamMcDev.project.Models.Tag;
import TeamMcDev.project.Models.data.IngredientRepository;
import TeamMcDev.project.Models.data.RecipeRepository;
import TeamMcDev.project.Models.data.TagRepository;
import TeamMcDev.project.Models.dto.RecipeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping()
    public List<Recipe> displayAllRecipes(){
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();

        return recipes;
    }

    @PostMapping(value = "add")
    public ResponseEntity<Object> addRecipe(@RequestBody RecipeDTO recipeDTO){
//        curl -X POST http://localhost:8080/recipes/add -H 'Content-type:application/json' -d '{"recipeName": "chicken", "directions": "boil"}'

        System.out.println(recipeDTO.getRecipeName());

        List<Ingredient> ingredientsList = new ArrayList<>();
        List<Tag> tagsList = new ArrayList<>();


            for( String ingredientName : recipeDTO.getIngredients()) {
                ingredientsList.add(ingredientRepository.findByIngredientName(ingredientName));
            }

            for( String tagName : recipeDTO.getTags()) {
                tagsList.add(tagRepository.findByTagName(tagName));
            }

            Recipe newRecipe = new Recipe(recipeDTO.getRecipeName(), recipeDTO.getDirections());
            newRecipe.setIngredients(ingredientsList);
            newRecipe.setTags(tagsList);

            recipeRepository.save(newRecipe);


            return ResponseEntity.status(201).body(newRecipe);
    }
}

//    @PostMapping
//    public ResponseEntity<Object> createNote(@RequestBody InboundNoteRepresentation noteDto) {
//        NoteEntity newNote = noteDto.toNoteEntity();
//        notesRepository.save(newNote);
//        return ResponseEntity.status(201).body(OutboundNoteRepresentation.fromNoteEntity(newNote));
//    }