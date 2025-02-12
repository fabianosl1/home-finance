package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionResponse {

    private long id;

    private String description;

    private double amount;

    private String type;

    public CreateTransactionResponse(Transaction transaction) {
        this.id = transaction.getId();
        this.description = transaction.getDescription();
        this.amount = transaction.getAmount();
        this.type = transaction.getType().name();
    }
}
