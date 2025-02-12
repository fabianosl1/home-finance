package fabiano.homefinanceapi.services;
import fabiano.homefinanceapi.dtos.PersonResponse;
import fabiano.homefinanceapi.dtos.PersonTransactionsResponse;
import fabiano.homefinanceapi.entities.Transaction;
import fabiano.homefinanceapi.enums.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonTransactionsService {

    private final PersonService personService;

    private final TransactionService transactionService;

    public List<PersonResponse> listAll() {
        var persons = personService.listAll();
        var transactions = transactionService.listAll();

        var response = new ArrayList<PersonResponse>();

        for (var person : persons) {
            var filtered = transactions.stream()
                    .filter(transaction -> transaction.getPerson().getId() == person.getId())
                    .toList();

            var values = calculate(filtered);

            response.add(new PersonResponse(person, values));
        }

        return response;
    }

    private static PersonTransactionsResponse calculate(List<Transaction> transactions) {
        double incomes = 0;
        double expenses = 0;

        for (var transaction : transactions) {
            if (TransactionType.EXPENSE.equals(transaction.getType())) {
                expenses += transaction.getAmount();
            } else {
                incomes += transaction.getAmount();
            }
        }

        double balance = incomes - expenses;

        return new PersonTransactionsResponse(expenses, incomes, balance);
    }
}
