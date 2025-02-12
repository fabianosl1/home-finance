package fabiano.homefinanceapi.services;

import fabiano.homefinanceapi.dtos.CreateTransactionRequest;
import fabiano.homefinanceapi.entities.Transaction;
import fabiano.homefinanceapi.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final PersonService personService;

    public Transaction create(long personId, CreateTransactionRequest createTransactionRequest) {
        if (createTransactionRequest.getAmount() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amount must be greater than 0");
        }

        if (createTransactionRequest.getDescription() == null || createTransactionRequest.getDescription().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Description cannot be empty");
        }

        var person = this.personService.findById(personId);
        var transaction = createTransactionRequest.makeTransaction(person);

        return transactionRepository.save(transaction);
    }

    public List<Transaction> listAll() {
        var transactions = this.transactionRepository.findAll();

        return Streamable.of(transactions).toList();
    }
}
