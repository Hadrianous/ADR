package api.intranet.responders;

import api.intranet.domain.fetcher.output.GetFetcherOutput;
import api.intranet.domain.exceptions.NotFoundException;
import api.intranet.domain.exceptions.ProcessingError;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Service
public class CreateFetcherJsonResponder extends GetFetcherJsonResponder<GetFetcherOutput> {

    @Override
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
