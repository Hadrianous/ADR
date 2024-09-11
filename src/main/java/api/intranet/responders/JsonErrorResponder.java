package api.intranet.responders;

import api.intranet.responders.exceptions.NotFoundException;
import api.intranet.responders.exceptions.ProcessingError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class JsonErrorResponder {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ProcessingError.class)
    public Map<String, String> handleUndefinedExceptions(
            MethodArgumentNotValidException ex
    ) {
        return processValidationErrors(ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(URISyntaxException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex
    ) {
        return processValidationErrors(ex);
    }

    private Map<String, String> processValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundExceptions() {
        return ResponseEntity.ok()
                .body("{\"message\":\"Not Found\"}");
    }
}
