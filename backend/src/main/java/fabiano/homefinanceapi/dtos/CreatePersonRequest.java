package fabiano.homefinanceapi.dtos;

import fabiano.homefinanceapi.entities.Person;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePersonRequest {

    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    @NotNull(message = "A idade é um campo obrigatorio")
    @Min(value = 0, message = "A idade não pode ser negativa")
    private int age;

    public Person makePerson() {
        var person = new Person();

        person.setName(name);
        person.setAge(age);

        return person;
    }
}
