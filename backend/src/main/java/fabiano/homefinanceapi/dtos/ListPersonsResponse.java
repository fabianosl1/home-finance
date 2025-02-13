package fabiano.homefinanceapi.dtos;

import lombok.Data;
import java.util.List;

import fabiano.homefinanceapi.entities.Person;

@Data
public class ListPersonsResponse {
    private List<PersonResponse> persons;

    public ListPersonsResponse(List<Person> persons) {
        this.persons = persons.stream()
                .map(PersonResponse::new)
                .toList();
    }
}
