package api.adr.responders;

import api.adr.domain.fetcher.output.GetFetcherOutput;
import api.adr.domain.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetFetcherJsonResponder<T extends GetFetcherOutput>{

    public ResponseEntity<Optional<T>> response(Optional<T> object) {
        if (object.isEmpty()) {
            throw new NotFoundException();
        }

        return ResponseEntity.ok()
                .body(object);
    }
}
