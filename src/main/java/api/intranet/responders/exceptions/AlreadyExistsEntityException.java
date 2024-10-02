package api.intranet.responders.exceptions;

public class AlreadyExistsEntityException extends RuntimeException {
    public AlreadyExistsEntityException(String message) {
        super(message);
    }
}
