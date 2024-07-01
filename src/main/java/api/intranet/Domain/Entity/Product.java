package api.intranet.Domain.Entity;

import jakarta.persistence.*;

@jakarta.persistence.Entity
public class Product extends api.intranet.Domain.Entity.Entity {

    @Column
    private String name;
}
