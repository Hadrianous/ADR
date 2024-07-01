package api.intranet.Action;

import api.intranet.Domain.Fetcher.GetFetcherHandler;
import api.intranet.Domain.Fetcher.Output.GetFetcherOutput;
import api.intranet.Responder.GetFetcherJsonResponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
