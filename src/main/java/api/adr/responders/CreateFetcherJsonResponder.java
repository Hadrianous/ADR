package api.adr.responders;

import api.adr.domain.fetcher.output.GetFetcherOutput;
import api.adr.domain.exceptions.NotFoundException;
import api.adr.domain.exceptions.ProcessingError;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Service
public class CreateFetcherJsonResponder<T extends GetFetcherOutput> {

    public ResponseEntity<Optional<GetFetcherOutput>> response(Optional<GetFetcherOutput> object) {
        if (object.isEmpty()) {
            throw new NotFoundException();
        }

        try {
            var uri = new URI("/fetcher/" + object.get().getId());
            return ResponseEntity.created(uri)
                    .body(object);

        } catch (URISyntaxException e) {
            throw new ProcessingError("Unable to generate entity URI");
        }
    }
}
