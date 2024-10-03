package api.intranet.domain.exceptions;

public class AlreadyExistsEntityException extends RuntimeException {
    public AlreadyExistsEntityException(String message) {
        super(message);
    }
}
