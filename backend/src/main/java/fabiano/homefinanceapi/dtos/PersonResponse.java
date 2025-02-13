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

    public PersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
    }
}
