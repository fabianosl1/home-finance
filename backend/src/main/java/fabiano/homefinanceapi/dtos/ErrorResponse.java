package fabiano.homefinanceapi.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {

    private List<String> errors;

    public ErrorResponse(List<String> errors) {
        this.errors = errors;
    }
}
