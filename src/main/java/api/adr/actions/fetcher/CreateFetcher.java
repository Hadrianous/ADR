package api.adr.actions.fetcher;

import api.adr.domain.fetcher.input.NewFetcherInput;
import api.adr.domain.fetcher.handlers.CreateFetcherHandler;
import api.adr.domain.fetcher.output.GetFetcherOutput;
import api.adr.responders.CreateFetcherJsonResponder;
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
