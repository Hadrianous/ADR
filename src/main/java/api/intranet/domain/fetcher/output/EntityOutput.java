package api.intranet.domain.fetcher.output;

public abstract class EntityOutput {

    protected Long id;

    public Long getId() {
        return id;
    }

    public abstract String getEntityName();
}
