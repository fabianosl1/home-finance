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

