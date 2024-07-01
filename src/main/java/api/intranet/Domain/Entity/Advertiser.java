package api.intranet.Domain.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
public class Advertiser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Advertiser(String name, Product product) {
        this.name = name;
        this.product = product;
    }

    public Advertiser() {

    }
}
