package fabiano.homefinanceapi.controllers;

import fabiano.homefinanceapi.dtos.CreatePersonRequest;
import fabiano.homefinanceapi.dtos.CreatePersonResponse;
import fabiano.homefinanceapi.dtos.ListPersonsAmountResponse;
import fabiano.homefinanceapi.dtos.ListPersonsResponse;
import fabiano.homefinanceapi.services.PersonService;
import fabiano.homefinanceapi.services.AmountsService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    private final AmountsService amountsService;

    @PostMapping
    public ResponseEntity<CreatePersonResponse> create(@Validated @RequestBody CreatePersonRequest request) {
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
        var persons = personService.listAll();
        var response = new ListPersonsResponse(persons);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/amounts")
    public ResponseEntity<ListPersonsAmountResponse> personTransactions() {
        var persons = personService.listAll();

        var amountsMap = amountsService.getAmountsMap();
        var amounts = List.copyOf(amountsMap.values());

        var totalAmounts = amountsService.calculateAmounts(amounts);

        var response = new ListPersonsAmountResponse(persons, amountsMap, totalAmounts);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
