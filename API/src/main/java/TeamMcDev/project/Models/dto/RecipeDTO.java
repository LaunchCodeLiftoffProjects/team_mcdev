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
    private String recipeNameDTO;

    @NotNull
    private String directionsDTO;

    @NotNull
    private List<String> ingredientsDTO;

    private List<String> tagsDTO;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TagRepository tagRepository;

    public RecipeDTO(@NotNull String recipeNameDTO, @NotNull String directionsDTO, @NotNull List<String> ingredientsDTO, List<String> tagsDTO) {
        this.recipeNameDTO = recipeNameDTO;
        this.directionsDTO = directionsDTO;
        this.ingredientsDTO = ingredientsDTO;
        this.tagsDTO = tagsDTO;
    }

    public RecipeDTO(){};

    public Recipe toRecipe() {
        Recipe newRecipe = new Recipe(this.recipeNameDTO, this.directionsDTO);

        List<Ingredient> ingredients = new ArrayList<>();
        List<Tag> tags = new ArrayList<>();

        for(int i = 0; i > ingredients.size(); i++) {
            ingredients.add(ingredientRepository.findByIngredientName(this.ingredientsDTO.get(i)));
        }

        for(int i = 0; i > tags.size(); i++) {
            tags.add(tagRepository.findByTagName(this.tagsDTO.get(i)));
        }

        newRecipe.setIngredients(ingredients);
        newRecipe.setTags(tags);

        return newRecipe;
    }

    public String getRecipeNameDTO() {
        return recipeNameDTO;
    }

    public String getDirectionsDTO() {
        return directionsDTO;
    }

    public List<String> getIngredientsDTO() {
        return ingredientsDTO;
    }

    public List<String> getTagsDTO() {
        return tagsDTO;
    }

}
