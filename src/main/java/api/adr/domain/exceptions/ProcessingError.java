package api.adr.domain.exceptions;

public class ProcessingError extends RuntimeException {
    public ProcessingError(String message) {
        super(message);
    }
}
