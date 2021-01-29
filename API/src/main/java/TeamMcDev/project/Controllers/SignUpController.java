package TeamMcDev.project.Controllers;

import TeamMcDev.project.Models.User;
import TeamMcDev.project.Models.dto.UserSignUpDTO;
import TeamMcDev.project.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SignUpController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signUpForm(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {
        User user = new User(firstName, lastName, email, password);
        UserSignUpDTO userSignUpDTO = new UserSignUpDTO(firstName, lastName, email);
        //userRepository.save(user);
        return ResponseEntity.status(201).body(userSignUpDTO);
    }
}



