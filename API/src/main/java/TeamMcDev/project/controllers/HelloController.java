package TeamMcDev.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// This defines the class as a controller.
// There are other controller options like @RestController
// https://www.baeldung.com/spring-controller-vs-restcontroller
@Controller
public class HelloController {

    @GetMapping
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        // @RequestParam gets values from the path. 
        // If you went to http://localhost:8080/?name=Joe it will say "Hello, Joe"
        // If you went to http://localhost:8080/ it would say "Hello, World" because the default value for name is set to "World"
        // Here the name value is added to the Thymeleaf template:
        model.addAttribute("name", name);
        // Here the thymeleaf template is returned:
        return "greeting";
    }
}
