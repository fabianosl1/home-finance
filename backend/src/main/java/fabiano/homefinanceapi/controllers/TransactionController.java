package fabiano.homefinanceapi.controllers;

import fabiano.homefinanceapi.dtos.ListTransactionsResponse;
import fabiano.homefinanceapi.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<ListTransactionsResponse> list() {
        var transactions = transactionService.listAll();
        var response = new ListTransactionsResponse(transactions);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
