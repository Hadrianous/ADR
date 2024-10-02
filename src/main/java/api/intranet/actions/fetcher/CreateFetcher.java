package api.intranet.actions.fetcher;

import api.intranet.domain.fetcher.input.NewFetcherInput;
import api.intranet.domain.fetcher.handlers.CreateFetcherHandler;
import api.intranet.domain.fetcher.output.GetFetcherOutput;
import api.intranet.responders.CreateFetcherJsonResponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CreateFetcher {

    private final CreateFetcherHandler handler;

    private final CreateFetcherJsonResponder responder;

    @Autowired
    public CreateFetcher(CreateFetcherHandler handler, CreateFetcherJsonResponder responder) {
        this.handler = handler;
        this.responder = responder;
    }

    @PostMapping("/fetcher")
    public ResponseEntity<Optional<GetFetcherOutput>> save(@RequestBody NewFetcherInput fetcher) {
        Optional<GetFetcherOutput> result = handler.execute(fetcher);
        return responder.response(result);
    }
}
