package TeamMcDev.project.controllers;

import TeamMcDev.project.models.Greeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin
public class GreetingController {

    private static final String template= "Salutations, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*without impairing the base query (http://localhost:8080/?name=User) to get a 'Hello, User" response,
    * created page: (localhost:8080/greeting) where query returns a JSON object with a ID# and greeting output.
    * the ID# and String output can be changed, but this creates base JSON output for further use */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }


}
