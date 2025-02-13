package fabiano.homefinanceapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fabiano.homefinanceapi.exceptions.DomainExpcetion;
import fabiano.homefinanceapi.exceptions.NotFoundException;

@RestControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.TEXT_PLAIN)
                .body("Internal Server Error");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationException(
            MethodArgumentNotValidException exception) {

        var messages = new ArrayList<String>();

        for (var error : exception.getBindingResult().getAllErrors()) {
            messages.add(error.getDefaultMessage());
        }

        var response = this.makeErrorResponse(messages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DomainExpcetion.class)
    public ResponseEntity<Map<String, List<String>>> handleDomainException(DomainExpcetion exception) {
        var message = List.of(exception.getMessage());

        var response = makeErrorResponse(message);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleNotFoundException(NotFoundException exception) {
        var message = List.of(exception.getMessage());

        var response = makeErrorResponse(message);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    private Map<String, List<String>> makeErrorResponse(List<String> erros) {
        var errors = new HashMap<String, List<String>>();
        errors.put("erros", erros);

        return errors;
    }
}
