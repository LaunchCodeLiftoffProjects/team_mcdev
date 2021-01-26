package TeamMcDev.project.Controllers;

import TeamMcDev.project.Models.Recipe;
import TeamMcDev.project.Models.data.IngredientRepository;
import TeamMcDev.project.Models.data.RecipeRepository;
import TeamMcDev.project.Models.data.TagRepository;
import TeamMcDev.project.Models.dto.RecipeDTO;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
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
    public ResponseEntity<Object> addRecipe(@RequestBody RecipeDTO recipeDTO){
//        curl -X POST http://localhost:8080/recipes/add -H 'Content-type:application/json' -d '{"recipeName": "chicken", "directions": "boil"}'

        Recipe newRecipe = recipeDTO.toRecipe();

        recipeRepository.save(newRecipe);

        System.out.println(recipeDTO);


        return ResponseEntity.status(201).body(newRecipe);
    }
}

//    @PostMapping
//    public ResponseEntity<Object> createNote(@RequestBody InboundNoteRepresentation noteDto) {
//        NoteEntity newNote = noteDto.toNoteEntity();
//        notesRepository.save(newNote);
//        return ResponseEntity.status(201).body(OutboundNoteRepresentation.fromNoteEntity(newNote));
//    }