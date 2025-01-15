package api.adr.domain.fetcher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Fetchers extends CrudRepository<Fetcher, Long> {
    Optional<Fetcher> findById(long id);
}