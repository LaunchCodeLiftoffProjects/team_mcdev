package TeamMcDev.project.Models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity{

    @NotBlank(message = "Name can not be blank!")
    @Size(min = 1, max = 100)
    private String recipeName;

    @NotBlank(message = "Please enter directions for your recipe!")
    private String directions;

    @NotBlank(message = "Must include at least one ingredient!")
    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    public Recipe(String recipeName, String directions) {
        this.recipeName = recipeName;
        this.directions = directions;
    }

    public Recipe(){}

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String name) {
        this.recipeName = recipeName;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return recipeName;
    }

    @ManyToOne
    private User user;

}
