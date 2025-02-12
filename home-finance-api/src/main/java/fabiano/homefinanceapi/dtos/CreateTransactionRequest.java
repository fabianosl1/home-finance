package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import fabiano.homefinanceapi.entities.Transaction;
import lombok.Data;

@Data
public class CreateTransactionRequest {
    private String description;

    private double amount;

    public Transaction makeTransaction(Person person) {
        Transaction transaction = new Transaction();

        transaction.setDescription(description);
        transaction.setAmount(amount);
        transaction.setPerson(person);

        return transaction;
    }
}
