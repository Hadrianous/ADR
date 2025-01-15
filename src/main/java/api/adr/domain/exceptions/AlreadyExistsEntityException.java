package api.adr.domain.exceptions;

public class AlreadyExistsEntityException extends RuntimeException {
    public AlreadyExistsEntityException(String message) {
        super(message);
    }
}
