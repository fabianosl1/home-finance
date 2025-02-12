package fabiano.homefinanceapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonTransactionsResponse {
    double expenses;

    double incomes;

    double balance;
}
