package api.intranet.actions;

import api.intranet.domain.fetcher.handlers.GetFetcherHandler;
import api.intranet.domain.fetcher.output.GetFetcherOutput;
import api.intranet.responders.GetFetcherJsonResponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GetFetcher {

    @Autowired
    private GetFetcherHandler handler;

    @Autowired
    private GetFetcherJsonResponder<GetFetcherOutput> responder;

    @GetMapping("/fetcher/{id}")
    public ResponseEntity<Optional<GetFetcherOutput>> invoke(@PathVariable long id) {

        var fetcher = handler.invoke(id);
        return responder.response(fetcher);
    }
}
