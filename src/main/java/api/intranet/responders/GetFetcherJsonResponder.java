package api.intranet.responders;

import api.intranet.domain.fetcher.output.GetFetcherOutput;
import api.intranet.responders.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public abstract class GetFetcherJsonResponder<T extends GetFetcherOutput>{

    public ResponseEntity<Optional<T>> response(Optional<T> object) {
        if (object.isEmpty()) {
            throw new NotFoundException();
        }

        return ResponseEntity.ok()
                .body(object);
    }
}
