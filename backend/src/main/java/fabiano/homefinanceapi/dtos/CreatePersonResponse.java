package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonResponse {
    private long id;

    private String name;

    private long age;

    public CreatePersonResponse(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
    }
}
