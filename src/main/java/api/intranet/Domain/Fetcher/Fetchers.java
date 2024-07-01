package api.intranet.Domain.Fetcher;

import api.intranet.Domain.Entity.Fetcher;
import api.intranet.Domain.Fetcher.Input.NewFetcherInput;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Fetchers extends CrudRepository<Fetcher, Long> {
    Optional<Fetcher> findById(long id);

    Fetcher save(NewFetcherInput fetcher);
}