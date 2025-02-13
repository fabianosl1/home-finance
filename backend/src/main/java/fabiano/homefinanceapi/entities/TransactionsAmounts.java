package fabiano.homefinanceapi.entities;

import fabiano.homefinanceapi.enums.TransactionType;
import lombok.Getter;

public class TransactionsAmounts {
    @Getter
    double expenses;

    @Getter
    double incomes;

    public TransactionsAmounts() {
        this.expenses = 0;
        this.incomes = 0;
    }

    public double getBalance() {
        return this.incomes - this.expenses;
    }

    public void add(Transaction transaction) {
        this.validate(transaction.getAmount());
        this.add(transaction.getAmount(), transaction.getType());
    }

    public void add(double amount, TransactionType type) {
        switch (type) {
            case EXPENSE -> this.expenses += amount;
            case INCOME -> this.incomes += amount;
        }
    }

    private void validate(double amount) {
        if (amount < 0) {
            throw new IllegalStateException("invalid income amount");
        }
    }
}
