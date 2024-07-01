package api.intranet.Responder;

import api.intranet.Domain.Fetcher.Output.GetFetcherOutput;
import api.intranet.Responder.exceptions.NotFoundException;
import api.intranet.Responder.exceptions.ProcessingError;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Component
public class CreateFetcherJsonResponder<T extends GetFetcherOutput> extends GetFetcherJsonResponder<GetFetcherOutput> {

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
