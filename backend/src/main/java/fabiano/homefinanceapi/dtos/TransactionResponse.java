package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Transaction;
import lombok.Data;

@Data
public class TransactionResponse {
    private long id;

    private String description;

    private double amount;

    private String type;

    public TransactionResponse(Transaction transaction) {
        this.id = transaction.getId();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.type = transaction.getType().name();
    }
}
