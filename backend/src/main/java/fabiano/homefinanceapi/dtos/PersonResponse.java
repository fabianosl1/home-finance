package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonResponse {
    private long id;

    private String name;

    private long age;

    private PersonTransactionsResponse transactions;

    public PersonResponse(Person person, PersonTransactionsResponse transactions) {
        this.transactions = transactions;

        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
    }
}
