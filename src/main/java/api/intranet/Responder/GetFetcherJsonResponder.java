package api.intranet.Responder;

import api.intranet.Domain.Fetcher.Output.GetFetcherOutput;
import api.intranet.Responder.exceptions.NotFoundException;
import api.intranet.Responder.exceptions.ProcessingError;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public abstract class GetFetcherJsonResponder<T extends GetFetcherOutput>{

    public ResponseEntity<Optional<GetFetcherOutput>> response(Optional<GetFetcherOutput> object) {

        if (object.isEmpty()) {
            throw new NotFoundException();
        }

        return ResponseEntity.ok()
                .body(object);
    }
}
