package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import fabiano.homefinanceapi.entities.TransactionsAmounts;
import lombok.Getter;
import lombok.Setter;

public class PersonAmountResponse extends PersonResponse {

    @Getter
    @Setter
    private TransactionsAmountsResponse amounts;

    public PersonAmountResponse(Person person, TransactionsAmounts amounts) {
        super(person);
        this.amounts = new TransactionsAmountsResponse(amounts);
    }
}
