package fabiano.homefinanceapi;

import java.util.ArrayList;
import java.util.List;

import fabiano.homefinanceapi.dtos.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fabiano.homefinanceapi.exceptions.DomainException;
import fabiano.homefinanceapi.exceptions.NotFoundException;

@RestControllerAdvice
@Log4j2
public class GlobalAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception exception) {
        log.error(exception);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.TEXT_PLAIN)
                .body("Internal Server Error");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception) {

        var messages = new ArrayList<String>();

        for (var error : exception.getBindingResult().getAllErrors()) {
            messages.add(error.getDefaultMessage());
        }

        var response = new ErrorResponse(messages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException exception) {
        var message = List.of(exception.getMessage());

        var response = new ErrorResponse(message);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
        var message = List.of(exception.getMessage());

        var response = new ErrorResponse(message);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
