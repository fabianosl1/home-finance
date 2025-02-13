package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import fabiano.homefinanceapi.entities.Transaction;
import fabiano.homefinanceapi.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTransactionRequest {

    @NotBlank(message = "A descrição não pode ser vazio")
    private String description;

    @NotNull(message = "O valor é obrigatorio")
    @Positive(message = "Valor deve ser positivo")
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
