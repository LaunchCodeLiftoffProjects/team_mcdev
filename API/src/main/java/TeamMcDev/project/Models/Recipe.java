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

    private String directions;

    @ManyToMany
    private final List<Ingredient> ingredients = new ArrayList<>();


    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();

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

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return recipeName;
    }

    @ManyToOne
    private User user;

}
