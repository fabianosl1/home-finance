package fabiano.homefinanceapi.dtos;
import lombok.Data;
import java.util.List;

@Data
public class ListPersonsResponse {
    private List<PersonResponse> persons;

    public ListPersonsResponse(List<PersonResponse> persons) {
        this.persons = persons;
    }
}

