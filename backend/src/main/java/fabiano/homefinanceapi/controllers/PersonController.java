package fabiano.homefinanceapi.controllers;

import fabiano.homefinanceapi.dtos.CreatePersonRequest;
import fabiano.homefinanceapi.dtos.CreatePersonResponse;
import fabiano.homefinanceapi.dtos.ListPersonsResponse;
import fabiano.homefinanceapi.services.PersonService;
import fabiano.homefinanceapi.services.PersonTransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    private final PersonTransactionsService personTransactionsService;

    @PostMapping
    public ResponseEntity<CreatePersonResponse> create(@RequestBody CreatePersonRequest request) {
        var person = personService.create(request);
        var response = new CreatePersonResponse(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        personService.destroy(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<ListPersonsResponse> list() {
        var persons = personTransactionsService.listAll();
        var response = new ListPersonsResponse(persons);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
