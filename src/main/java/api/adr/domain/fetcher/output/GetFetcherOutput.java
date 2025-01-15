package api.adr.domain.fetcher.output;

import api.adr.domain.fetcher.Fetcher;
import api.adr.domain.fetcher.FetcherStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO for {@link Fetcher}
 */
public class GetFetcherOutput extends EntityOutput implements Serializable {

    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;
    private final String name;
    private final String type;
    private final String url;
    private final String tag;
    private final Integer frequency;
    private final FetcherStatus status;
    private final String dateFormat;

    @Override
    public String getEntityName() {
        return "Fetcher";
    }

    public GetFetcherOutput(Long id, LocalDateTime createdAt, LocalDateTime updateAt, String name, String type, String url, String tag, Integer frequency, FetcherStatus status, String dateFormat) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.name = name;
        this.type = type;
        this.url = url;
        this.tag = tag;
        this.frequency = frequency;
        this.status = status;
        this.dateFormat = dateFormat;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getTag() {
        return tag;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public FetcherStatus getStatus() {
        return status;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetFetcherOutput entity = (GetFetcherOutput) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updateAt, entity.updateAt) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.url, entity.url) &&
                Objects.equals(this.tag, entity.tag) &&
                Objects.equals(this.frequency, entity.frequency) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.dateFormat, entity.dateFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updateAt, name, type, url, tag, frequency, status, dateFormat);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "createdAt = " + createdAt + ", " +
                "updateAt = " + updateAt + ", " +
                "name = " + name + ", " +
                "type = " + type + ", " +
                "url = " + url + ", " +
                "tag = " + tag + ", " +
                "frequency = " + frequency + ", " +
                "status = " + status + ", " +
                "dateFormat = " + dateFormat + ")";
    }
}