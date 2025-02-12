package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import lombok.Data;

@Data
public class CreatePersonRequest {
    private String name;

    private int age;

    public Person makePerson() {
        var person = new Person();

        person.setName(name);
        person.setAge(age);

        return person;
    }
}
