package api.intranet.actions.fetcher;

import api.intranet.domain.fetcher.handlers.GetFetcherHandler;
import api.intranet.domain.fetcher.output.GetFetcherOutput;
import api.intranet.responders.GetFetcherJsonResponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GetFetcher {

    private final GetFetcherHandler handler;

    private final GetFetcherJsonResponder<GetFetcherOutput> responder;

    @Autowired
    public GetFetcher(GetFetcherJsonResponder<GetFetcherOutput> responder, GetFetcherHandler handler) {
        this.responder = responder;
        this.handler = handler;
    }

    @GetMapping("/fetcher/{id}")
    public ResponseEntity<Optional<GetFetcherOutput>> invoke(@PathVariable long id) {
        var fetcher = handler.invoke(id);
        return responder.response(fetcher);
    }
}
