package api.intranet.Domain.Fetcher;

import api.intranet.Domain.Fetcher.Output.GetFetcherOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetFetcherHandler {

    @Autowired
    Fetchers fetchers;

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
