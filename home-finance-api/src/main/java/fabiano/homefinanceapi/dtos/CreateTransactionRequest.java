package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import fabiano.homefinanceapi.entities.Transaction;
import fabiano.homefinanceapi.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTransactionRequest {
    private String description;

    private double amount;

    private TransactionType type;

    public Transaction makeTransaction(Person person) {
        Transaction transaction = new Transaction();

        transaction.setDescription(description);
        transaction.setAmount(amount);
        transaction.setPerson(person);
        transaction.setType(type);

        return transaction;
    }
}
