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

