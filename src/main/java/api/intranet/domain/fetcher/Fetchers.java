package api.intranet.domain.fetcher;

import api.intranet.domain.fetcher.input.NewFetcherInput;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Fetchers extends CrudRepository<Fetcher, Long> {
    Optional<Fetcher> findById(long id);
}