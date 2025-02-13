package fabiano.homefinanceapi.exceptions;

import lombok.Getter;

public class DomainExpcetion extends RuntimeException {
    @Getter
    private String message;

    public DomainExpcetion(String message) {
        super();

        this.message = message;
    }

}
