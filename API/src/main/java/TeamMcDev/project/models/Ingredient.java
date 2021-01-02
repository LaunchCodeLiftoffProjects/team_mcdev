package TeamMcDev.project.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity{

    @NotBlank(message = "Name can not be blank!")
    @Size(min = 1, max = 100)
    private String ingredientName;

    private String type;

    @ManyToMany(mappedBy = "ingredients")
    private final List<Recipe> recipes = new ArrayList<>();

    public Ingredient(String ingredientName, String type) {
        this.ingredientName = ingredientName;
        this.type = type;
    }

    public Ingredient(){}

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String name) {
        this.ingredientName = ingredientName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return ingredientName;
    }
}
