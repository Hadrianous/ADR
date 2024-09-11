package api.intranet.responders.exceptions;

public class ProcessingError extends RuntimeException {
    public ProcessingError(String message) {
        super(message);
    }
}
