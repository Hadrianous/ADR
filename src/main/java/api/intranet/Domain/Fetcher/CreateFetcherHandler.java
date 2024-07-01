package api.intranet.Domain.Fetcher;

import api.intranet.Domain.Entity.Fetcher;
import api.intranet.Domain.Fetcher.Input.NewFetcherInput;
import api.intranet.Domain.Fetcher.Output.GetFetcherOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateFetcherHandler {

    @Autowired
    private Fetchers repository;

    public Optional<GetFetcherOutput> execute(NewFetcherInput fetcherInput) {
        Fetcher fetcher = new Fetcher(
                fetcherInput.getName(),
                fetcherInput.getType(),
                fetcherInput.getUrl(),
                fetcherInput.getTag(),
                fetcherInput.getFrequency(),
                fetcherInput.getStatus(),
                fetcherInput.getDateFormat()
                );

        var savedFetcher = repository.save(fetcher);

        return Optional.of(new GetFetcherOutput(
                savedFetcher.getId(),
                savedFetcher.getCreatedAt(),
                savedFetcher.getUpdateAt(),
                savedFetcher.getName(),
                savedFetcher.getType(),
                savedFetcher.getUrl(),
                savedFetcher.getTag(),
                savedFetcher.getFrequency(),
                savedFetcher.getStatus(),
                savedFetcher.getDateFormat()
        ));
    }
}
