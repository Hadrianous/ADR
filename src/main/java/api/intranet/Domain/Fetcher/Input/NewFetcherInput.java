package api.intranet.Domain.Fetcher.Input;

import api.intranet.Domain.Fetcher.FetcherStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link api.intranet.Domain.Entity.Fetcher}
 */
public class NewFetcherInput implements Serializable {

    @NotBlank
    private final String name;
    @NotBlank
    @Enumerated(EnumType.ORDINAL)
    private final String type;
    private final String url;
    private final String tag;
    @NotBlank
    private final Integer frequency;
    @NotBlank
    private final FetcherStatus status;
    @DateTimeFormat
    private final String dateFormat;

    public NewFetcherInput(String name, String type, String url, String tag, Integer frequency, FetcherStatus status, String dateFormat) {
        this.name = name;
        this.type = type;
        this.url = url;
        this.tag = tag;
        this.frequency = frequency;
        this.status = status;
        this.dateFormat = dateFormat;
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
        NewFetcherInput entity = (NewFetcherInput) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.url, entity.url) &&
                Objects.equals(this.tag, entity.tag) &&
                Objects.equals(this.frequency, entity.frequency) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.dateFormat, entity.dateFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, url, tag, frequency, status, dateFormat);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "type = " + type + ", " +
                "url = " + url + ", " +
                "tag = " + tag + ", " +
                "frequency = " + frequency + ", " +
                "status = " + status + ", " +
                "dateFormat = " + dateFormat + ")";
    }
}