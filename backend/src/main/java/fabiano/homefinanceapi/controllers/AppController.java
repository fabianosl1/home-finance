package fabiano.homefinanceapi.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/")
public class AppController {

    @GetMapping
    public ResponseEntity<String> index() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body("API live");
    }

}
