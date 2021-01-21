package TeamMcDev.project.Controllers;

import TeamMcDev.project.Models.Ingredient;
import TeamMcDev.project.Models.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping()
    public ResponseEntity<Object> displayAllIngredients() {

        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();

        return ResponseEntity.status(200).body(ingredients);

    }
}
