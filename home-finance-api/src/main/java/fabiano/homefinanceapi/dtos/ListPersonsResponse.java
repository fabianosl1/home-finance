package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import lombok.Data;

import java.util.List;


@Data
public class ListPersonsResponse {
    private List<PersonResponse> persons;

    public ListPersonsResponse(List<Person> persons) {
        this.persons = persons.stream()
                .map(PersonResponse::new)
                .toList();
    }
}

class PersonResponse {
    private long id;

    private String name;

    private long age;

    public PersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
    }
}