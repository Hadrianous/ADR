package api.adr.domain.fetcher;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@Table(name = "fetcher")
public class Fetcher extends api.adr.domain.persistence.Entity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column
    private String url;

    @Column
    private String tag;

    @Column
    private Integer frequency;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private FetcherStatus status;

    @Column
    private String dateFormat;

    public Fetcher(String name, String type, String url, String tag, Integer frequency, FetcherStatus status, String dateFormat) {
        this.name = name;
        this.type = type;
        this.url = url;
        this.tag = tag;
        this.frequency = frequency;
        this.status = status;
        this.dateFormat = dateFormat;
    }

    public Fetcher() {

    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public FetcherStatus getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getTag() {
        return tag;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fetcher fetcher)) return false;
        return Objects.equals(getId(), fetcher.getId()) && Objects.equals(getName(), fetcher.getName()) && Objects.equals(type, fetcher.type) && Objects.equals(getUrl(), fetcher.getUrl()) && Objects.equals(tag, fetcher.tag) && Objects.equals(getFrequency(), fetcher.getFrequency()) && getStatus() == fetcher.getStatus() && Objects.equals(dateFormat, fetcher.dateFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), type, getUrl(), tag, getFrequency(), getStatus(), dateFormat);
    }
}
