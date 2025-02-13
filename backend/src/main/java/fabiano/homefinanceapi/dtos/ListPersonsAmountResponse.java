package fabiano.homefinanceapi.dtos;

import lombok.Data;
import java.util.List;
import java.util.Map;

import fabiano.homefinanceapi.entities.Person;
import fabiano.homefinanceapi.entities.TransactionsAmounts;

@Data
public class ListPersonsAmountResponse {
    private List<PersonAmountResponse> persons;

    private TransactionsAmountsResponse amounts;

    public ListPersonsAmountResponse(
            List<Person> persons,
            Map<Long, TransactionsAmounts> amountsMap,
            TransactionsAmounts totalAmounts) {

        this.persons = persons.stream()
                .map(person -> {
                    var personAmount = amountsMap.getOrDefault(person.getId(), new TransactionsAmounts());
                    return new PersonAmountResponse(person, personAmount);
                }).toList();

        this.amounts = new TransactionsAmountsResponse(totalAmounts);
    }
}
