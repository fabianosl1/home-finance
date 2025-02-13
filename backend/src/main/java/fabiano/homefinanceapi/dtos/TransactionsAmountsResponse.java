package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.TransactionsAmounts;
import lombok.Data;

@Data
public class TransactionsAmountsResponse {
    double expenses;

    double incomes;

    double balance;

    public TransactionsAmountsResponse(TransactionsAmounts amounts) {
        this.expenses = amounts.getExpenses();
        this.incomes = amounts.getIncomes();
        this.balance = amounts.getBalance();
    }
}
