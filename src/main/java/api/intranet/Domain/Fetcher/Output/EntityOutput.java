package api.intranet.Domain.Fetcher.Output;

public abstract class EntityOutput {

    protected Long id;

    protected String entityName;

    public Long getId() {
        return id;
    }

    public String getEntityName() {
        return entityName;
    }
}
