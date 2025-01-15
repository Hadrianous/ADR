package api.adr.domain.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;

    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(nullable = false)
    protected LocalDateTime updateAt;

    public Long getId() {
        return id;
    }

    @PreUpdate
    public void update() {
        updateAt = LocalDateTime.now();
    }

    @PrePersist
    public void create() {
        createdAt = LocalDateTime.now();
        update();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
}
