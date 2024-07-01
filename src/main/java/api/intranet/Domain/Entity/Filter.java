package api.intranet.Domain.Entity;

import jakarta.persistence.*;

@jakarta.persistence.Entity
public class Filter extends api.intranet.Domain.Entity.Entity {

    @Column
    private String name;

    @Column
    private String field;

    @Column
    private String value;
}
