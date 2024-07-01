package api.intranet.Responder.exceptions;

public class ProcessingError extends RuntimeException {
    public ProcessingError(String message) {
        super(message);
    }
}
