package TeamMcDev.project.Models.dto;

import TeamMcDev.project.Models.Ingredient;
import TeamMcDev.project.Models.Recipe;
import TeamMcDev.project.Models.Tag;
import TeamMcDev.project.Models.data.IngredientRepository;
import TeamMcDev.project.Models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {

    @NotNull
    private String recipeName;

    @NotNull
    private String directions;

    @NotNull
    private List<String> ingredients;
//
//    private List<String> tags;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TagRepository tagRepository;

    public RecipeDTO(@NotNull String recipeName, @NotNull String directions, @NotNull List<String> ingredients) {
        this.recipeName = recipeName;
        this.directions = directions;
        this.ingredients = ingredients;
//        this.tags = tags;
    }

    public RecipeDTO(){};

//    public Recipe toRecipe() {
////        Recipe newRecipe = new Recipe(this.recipeName, this.directions);
//
//        List<Ingredient> ingredientsList = new ArrayList<>();
////        List<String> tags = new ArrayList<>();
//
//        for(int i = 0; i > this.ingredients.size(); i++) {
//            ingredientsList.add(ingredientRepository.findByIngredientName(this.ingredients.get(i)));
//        }
////
////        for(int i = 0; i > tags.size(); i++) {
////            tags.add(tagRepository.findByTagName(this.tagsDTO.get(i)));
////        }
////
////        newRecipe.addIngredients(ingredients);
////        newRecipe.setTags(tags);
//
//        return new Recipe(this.recipeName, this.directions, ingredientsList);
//    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getDirections() {
        return directions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
//
//    public List<String> getTags() {
//        return tags;
//    }

}
