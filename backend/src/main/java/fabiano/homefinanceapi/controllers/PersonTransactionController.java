package fabiano.homefinanceapi.controllers;


import fabiano.homefinanceapi.dtos.CreateTransactionRequest;
import fabiano.homefinanceapi.dtos.CreateTransactionResponse;
import fabiano.homefinanceapi.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons/{personId}/transactions")
@RequiredArgsConstructor
public class PersonTransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<CreateTransactionResponse> createExpense(@PathVariable Long personId, @RequestBody CreateTransactionRequest request) {
        var transaction = transactionService.create(personId, request);
        var response = new CreateTransactionResponse(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
