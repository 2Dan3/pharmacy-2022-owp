package rs.ac.uns.ftn.dan.pharmacy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/helloWorld")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<String> Greet() {
        return new ResponseEntity("Hello from controller", HttpStatus.OK);
    }
}
