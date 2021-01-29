package TeamMcDev.project.Models.data;

import TeamMcDev.project.Models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer>  {

    Ingredient findByIngredientName(String ingredientName);
}
