package api.adr.domain.fetcher.handlers;

import api.adr.domain.fetcher.Fetchers;
import api.adr.domain.fetcher.output.GetFetcherOutput;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetFetcherHandler {

    Fetchers fetchers;

    GetFetcherHandler(Fetchers fetchers) {
        this.fetchers = fetchers;
    }

    public Optional<GetFetcherOutput> invoke(long id) {
        return fetchers.findById(id).map(
                findResult -> new GetFetcherOutput(
                        findResult.getId(),
                        findResult.getCreatedAt(),
                        findResult.getUpdateAt(),
                        findResult.getName(),
                        findResult.getType(),
                        findResult.getUrl(),
                        findResult.getTag(),
                        findResult.getFrequency(),
                        findResult.getStatus(),
                        findResult.getDateFormat()
                )
        );
    }
}
