package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class ListTransactionsResponse {

    private List<TransactionResponse> transactions;

    public ListTransactionsResponse(List<Transaction> transactions) {
        this.transactions = transactions.stream()
                .map(TransactionResponse::new)
                .toList();
    }
}

@Data
class TransactionResponse {
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
