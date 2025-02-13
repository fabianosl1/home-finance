package fabiano.homefinanceapi.services;

import fabiano.homefinanceapi.dtos.CreateTransactionRequest;
import fabiano.homefinanceapi.entities.Person;
import fabiano.homefinanceapi.entities.Transaction;
import fabiano.homefinanceapi.enums.TransactionType;
import fabiano.homefinanceapi.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final PersonService personService;

    public final static int MIN_AGE = 18;

    public Transaction create(long personId, CreateTransactionRequest createTransactionRequest) {
        var person = this.personService.findById(personId);

        validateAge(createTransactionRequest.getType(), person);

        var transaction = createTransactionRequest.makeTransaction(person);

        return transactionRepository.save(transaction);
    }

    private static void validateAge(TransactionType type, Person person) {
        if (TransactionType.INCOME.equals(type) && person.getAge() < MIN_AGE) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person age must be greater than 18");
        }
    }

    public List<Transaction> listAll() {
        var transactions = this.transactionRepository.findAll();
        log.info(transactions);
        return Streamable.of(transactions).toList();
    }
}
