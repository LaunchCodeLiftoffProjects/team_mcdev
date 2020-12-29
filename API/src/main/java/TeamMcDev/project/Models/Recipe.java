package TeamMcDev.project.Models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity{

    private String directions;

    @ManyToMany
    private final List<Ingredient> ingredients = new ArrayList<>();

    @ManyToOne
    private User user;
}
