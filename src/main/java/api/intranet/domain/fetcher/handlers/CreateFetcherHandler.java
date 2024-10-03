package api.intranet.domain.fetcher.handlers;

import api.intranet.domain.fetcher.Fetcher;
import api.intranet.domain.fetcher.Fetchers;
import api.intranet.domain.fetcher.input.NewFetcherInput;
import api.intranet.domain.fetcher.output.GetFetcherOutput;
import api.intranet.domain.exceptions.AlreadyExistsEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

        try {
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
        } catch (DataIntegrityViolationException e) {
            throw new AlreadyExistsEntityException(String.format("The fetcher %s already exists", fetcher.getName()));
        }
    }
}
