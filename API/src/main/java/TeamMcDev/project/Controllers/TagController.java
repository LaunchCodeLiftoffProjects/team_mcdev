package TeamMcDev.project.Controllers;

import TeamMcDev.project.Models.Ingredient;
import TeamMcDev.project.Models.Tag;
import TeamMcDev.project.Models.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping()
    public ResponseEntity<Object> displayAllTags() {

        List<Tag> tags = (List<Tag>) tagRepository.findAll();

        return ResponseEntity.status(200).body(tags);

    }
}
