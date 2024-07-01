package api.intranet.Action;

import api.intranet.Domain.Fetcher.Input.NewFetcherInput;
import api.intranet.Domain.Fetcher.CreateFetcherHandler;
import api.intranet.Domain.Fetcher.Output.GetFetcherOutput;
import api.intranet.Responder.CreateFetcherJsonResponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CreateFetcher {

    @Autowired
    private CreateFetcherHandler handler;

    @Autowired
    private CreateFetcherJsonResponder<GetFetcherOutput> responder;

    @PostMapping("/fetcher")
    public ResponseEntity<Optional<GetFetcherOutput>> save(@RequestBody NewFetcherInput fetcher) {
        Optional<GetFetcherOutput> result = handler.execute(fetcher);
        return responder.response(result);
    }
}
