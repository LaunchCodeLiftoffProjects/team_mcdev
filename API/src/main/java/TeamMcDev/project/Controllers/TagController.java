package TeamMcDev.project.Controllers;

import TeamMcDev.project.Models.Tag;
import TeamMcDev.project.Models.data.RecipeRepository;
import TeamMcDev.project.Models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;
    private RecipeRepository recipeRepository;

    @GetMapping()
    public ResponseEntity<Object> displayAllTags() {

        List<Tag> tags = (List<Tag>) tagRepository.findAll();

        return ResponseEntity.status(200).body(tags);

    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getRecipesForTag(@PathVariable Integer id) {

        Optional<Tag> optTag = tagRepository.findById(id);

        if(optTag.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        else {
            Tag tag = optTag.get();

            return ResponseEntity.status(200).body(
                 tag.getRecipes()
            );
        }
    }
}
