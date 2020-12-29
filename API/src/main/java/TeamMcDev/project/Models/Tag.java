package TeamMcDev.project.Models;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Tag extends AbstractEntity{

    @NotBlank(message = "Name can not be blank!")
    @Size(min = 1, max = 100)
    private String tagName;

    @ManyToMany(mappedBy = "tags")
    private final List<Recipe> recipes = new ArrayList<>();

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Tag(){}

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return tagName;
    }
}
